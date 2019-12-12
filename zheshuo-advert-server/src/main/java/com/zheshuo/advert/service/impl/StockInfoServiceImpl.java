package com.zheshuo.advert.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zheshuo.advert.core.easyexcel.EasyExcelExecutor;
import com.zheshuo.advert.core.easyexcel.ExportSheetDetail;
import com.zheshuo.advert.core.mapper.Mapper;
import com.zheshuo.advert.export.StockInfoExport;
import com.zheshuo.advert.repository.StockInfoRepository;
import com.zheshuo.advert.entity.StockInfo;
import com.zheshuo.advert.service.StockInfoService;
import com.zheshuo.advert.request.StockInfoRequest;
import com.zheshuo.advert.response.StockInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import com.zheshuo.advert.utils.OutputUtil;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * (StockInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:53:24
 */
@Service
public class StockInfoServiceImpl implements StockInfoService {
    @Resource
    private StockInfoRepository stockInfoRepository;

    @Override
    public OutputDTO<PageData<StockInfoResponse>> loadPage( StockInfoRequest stockInfoRequest ) {
        final Page<StockInfo> page = stockInfoRepository
            .page(stockInfoRequest.page(), stockInfoRequest.queryWrapper());
        return OutputUtil.conveterPage(StockInfoResponse.class, page);
    }

    @Override
    public OutputDTO<List<StockInfoResponse>> loadList( StockInfoRequest stockInfoRequest ) {
        final List<StockInfo> list = stockInfoRepository
            .list(stockInfoRequest.queryWrapper());
        return OutputUtil.conveterList(StockInfoResponse.class, list);
    }

    @Override
    public OutputDTO<StockInfoResponse> loadDetail( Serializable id ) {
        final StockInfo stockInfo = stockInfoRepository.getById(id);
        return OutputUtil.conveter(StockInfoResponse.class, stockInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutputDTO<Void> saveStockInfo( StockInfoRequest stockInfoRequest ) {
        stockInfoRepository.save(Mapper.map(stockInfoRequest, StockInfo.class));
        return new OutputDTO<>().success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OutputDTO<Void> updateStockInfo( StockInfoRequest stockInfoRequest ) {
        stockInfoRepository
            .update(Mapper.map(stockInfoRequest, StockInfo.class), stockInfoRequest.queryWrapper());
        return new OutputDTO<>().success();
    }
    
    @Override
    public void exportStockInfo( StockInfoRequest stockInfoRequest ) {
        final List<StockInfo> list = stockInfoRepository
            .list(stockInfoRequest.queryWrapper());
        final List<ExportSheetDetail<StockInfoExport, StockInfo>> exportSheetDetails = new ArrayList<>();
        final ExportSheetDetail<StockInfoExport, StockInfo> exportExportSheetDetail =
            new ExportSheetDetail<>(StockInfoExport.class, list, null, 1, 0);
        exportSheetDetails.add(exportExportSheetDetail);
        EasyExcelExecutor.exportMoreSheet("自己定义文件名称", exportSheetDetails);
    }
    
}