package com.zheshuo.advert.service.impl;

import com.zheshuo.advert.core.cache.AdminLoginCache;
import com.zheshuo.advert.core.cache.AdminLoginCache.SecurityUser;
import com.zheshuo.advert.core.easyexcel.EasyExcelExecutor;
import com.zheshuo.advert.core.easyexcel.ExportSheetDetail;
import com.zheshuo.advert.core.utils.WebUtils;
import com.zheshuo.advert.export.AdminInfoExport;
import com.zheshuo.advert.core.mapper.Mapper;
import com.zheshuo.advert.repository.AdminInfoRepository;
import com.zheshuo.advert.entity.AdminInfo;
import com.zheshuo.advert.request.AdminInfoLoginRequest;
import com.zheshuo.advert.service.AdminInfoService;
import com.zheshuo.advert.request.AdminInfoRequest;
import com.zheshuo.advert.response.AdminInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import com.zheshuo.advert.utils.OutputUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;


/**
 * 用户(AdminInfo)
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {
    @Resource
    private AdminInfoRepository adminInfoRepository;
    @Resource
    private AdminLoginCache adminLoginCache;

    @Override
    public OutputDTO<PageData<AdminInfoResponse>> loadPage( AdminInfoRequest adminInfoRequest ) {
        final Page<AdminInfo> page = adminInfoRepository
            .page(adminInfoRequest.page(), adminInfoRequest.queryWrapper());
        return OutputUtil.conveterPage(AdminInfoResponse.class, page);
    }

    @Override
    public OutputDTO<List<AdminInfoResponse>> loadList( AdminInfoRequest adminInfoRequest ) {
        final List<AdminInfo> list = adminInfoRepository
            .list(adminInfoRequest.queryWrapper());
        return OutputUtil.conveterList(AdminInfoResponse.class, list);
    }

    @Override
    public OutputDTO<AdminInfoResponse> loadDetail( Serializable id ) {
        final AdminInfo adminInfo = adminInfoRepository.getById(id);
        return OutputUtil.conveter(AdminInfoResponse.class, adminInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutputDTO<Void> saveAdminInfo( AdminInfoRequest adminInfoRequest ) {
        adminInfoRepository.save(Mapper.map(adminInfoRequest, AdminInfo.class));
        return new OutputDTO<>().success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutputDTO<Void> updateAdminInfo( AdminInfoRequest adminInfoRequest ) {
        adminInfoRepository
            .update(Mapper.map(adminInfoRequest, AdminInfo.class), adminInfoRequest.queryWrapper());
        return new OutputDTO<>().success();
    }
    
    @Override
    public void exportAdminInfo( AdminInfoRequest adminInfoRequest ) {
        final List<AdminInfo> list = adminInfoRepository
            .list(adminInfoRequest.queryWrapper());
        final List<ExportSheetDetail<AdminInfoExport, AdminInfo>> exportSheetDetails = new ArrayList<>();
        final ExportSheetDetail<AdminInfoExport, AdminInfo> exportExportSheetDetail =
            new ExportSheetDetail<>(AdminInfoExport.class, list, null, 1, 0);
        exportSheetDetails.add(exportExportSheetDetail);
        EasyExcelExecutor.exportMoreSheet("自己定义文件名称", exportSheetDetails);
    }

    @Override
    public OutputDTO<Void> login( AdminInfoLoginRequest adminInfoLoginRequest ) {
        final AdminInfo adminInfo = adminInfoRepository.getOne(adminInfoLoginRequest.queryWrapper());
        if(Objects.nonNull(adminInfo)) {
            String token = UUID.fromString(adminInfoLoginRequest.getUsername() + adminInfoLoginRequest.getPassword()).toString();
            adminLoginCache.register(token, Mapper.map(adminInfo, SecurityUser.class));
        }
        return new OutputDTO<>().success();
    }

    @Override
    public OutputDTO<Void> loginOut() {
        final String token = Objects.requireNonNull(WebUtils.getRequest()).getHeader("login-token");
        adminLoginCache.remove(token);
        return new OutputDTO<>().success();
    }

}