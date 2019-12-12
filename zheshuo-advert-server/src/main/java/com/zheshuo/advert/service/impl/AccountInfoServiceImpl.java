package com.zheshuo.advert.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zheshuo.advert.core.mapper.Mapper;
import com.zheshuo.advert.repository.AccountInfoRepository;
import com.zheshuo.advert.entity.AccountInfo;
import com.zheshuo.advert.service.AccountInfoService;
import com.zheshuo.advert.request.AccountInfoRequest;
import com.zheshuo.advert.response.AccountInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.utils.OutputUtil;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * 自定义demo表(AccountInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:40:02
 */
@Service
public class AccountInfoServiceImpl implements AccountInfoService {
    @Resource
    private AccountInfoRepository accountInfoRepository;

    @Override
    public OutputDTO<PageData<AccountInfoResponse>> loadPage( AccountInfoRequest accountInfoRequest ) {
        final Page<AccountInfo> page = accountInfoRepository
            .page(accountInfoRequest.page(), accountInfoRequest.queryWrapper());
        return OutputUtil.conveterPage(AccountInfoResponse.class, page);
    }

    @Override
    public OutputDTO<List<AccountInfoResponse>> loadList( AccountInfoRequest accountInfoRequest ) {
        final List<AccountInfo> list = accountInfoRepository
            .list(accountInfoRequest.queryWrapper());
        return OutputUtil.conveterList(AccountInfoResponse.class, list);
    }

    @Override
    public OutputDTO<AccountInfoResponse> loadDetail( Serializable id ) {
        final AccountInfo accountInfo = accountInfoRepository.getById(id);
        return OutputUtil.conveter(AccountInfoResponse.class, accountInfo);
    }

    @Override
    public OutputDTO<Void> saveAccountInfo( AccountInfoRequest accountInfoRequest ) {
        accountInfoRepository.save(Mapper.map(accountInfoRequest, AccountInfo.class));
        return new OutputDTO<>().success();
    }

    @Override
    public OutputDTO<Void> updateAccountInfo( AccountInfoRequest accountInfoRequest ) {
        accountInfoRepository
            .update(Mapper.map(accountInfoRequest, AccountInfo.class), accountInfoRequest.queryWrapper());
        return new OutputDTO<>().success();
    }
    
    @Override
    public void exportAccountInfo( AccountInfoRequest accountInfoRequest ) {
        final List<AccountInfo> list = accountInfoRepository
            .list(accountInfoRequest.queryWrapper());
        final List<ExportSheetDetail<AccountInfoExport, AccountInfo>> exportSheetDetails = new ArrayList<>();
        final ExportSheetDetail<AccountInfoExport, AccountInfo> exportExportSheetDetail =
            new ExportSheetDetail<>(AccountInfoExport.class, list, null, 1, 0);
        exportSheetDetails.add(exportExportSheetDetail);
        EasyExcelExecutor.exportMoreSheet("自己定义文件名称", exportSheetDetails);
    }
    
}