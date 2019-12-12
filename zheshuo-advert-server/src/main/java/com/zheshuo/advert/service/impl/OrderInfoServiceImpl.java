package com.zheshuo.advert.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zheshuo.advert.core.easyexcel.EasyExcelExecutor;
import com.zheshuo.advert.core.easyexcel.ExportSheetDetail;
import com.zheshuo.advert.core.mapper.Mapper;
import com.zheshuo.advert.export.OrderInfoExport;
import com.zheshuo.advert.repository.OrderInfoRepository;
import com.zheshuo.advert.entity.OrderInfo;
import com.zheshuo.advert.service.OrderInfoService;
import com.zheshuo.advert.request.OrderInfoRequest;
import com.zheshuo.advert.response.OrderInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import com.zheshuo.advert.utils.OutputUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:50:23
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoRepository orderInfoRepository;

    @Override
    public OutputDTO<PageData<OrderInfoResponse>> loadPage( OrderInfoRequest orderInfoRequest ) {
        final Page<OrderInfo> page = orderInfoRepository
            .page(orderInfoRequest.page(), orderInfoRequest.queryWrapper());
        return OutputUtil.conveterPage(OrderInfoResponse.class, page);
    }

    @Override
    public OutputDTO<List<OrderInfoResponse>> loadList( OrderInfoRequest orderInfoRequest ) {
        final List<OrderInfo> list = orderInfoRepository
            .list(orderInfoRequest.queryWrapper());
        return OutputUtil.conveterList(OrderInfoResponse.class, list);
    }

    @Override
    public OutputDTO<OrderInfoResponse> loadDetail( Serializable id ) {
        final OrderInfo orderInfo = orderInfoRepository.getById(id);
        return OutputUtil.conveter(OrderInfoResponse.class, orderInfo);
    }

    @Override
    public OutputDTO<Void> saveOrderInfo( OrderInfoRequest orderInfoRequest ) {
        orderInfoRepository.save(Mapper.map(orderInfoRequest, OrderInfo.class));
        return new OutputDTO<>().success();
    }

    @Override
    public OutputDTO<Void> updateOrderInfo( OrderInfoRequest orderInfoRequest ) {
        orderInfoRepository
            .update(Mapper.map(orderInfoRequest, OrderInfo.class), orderInfoRequest.queryWrapper());
        return new OutputDTO<>().success();
    }
    
    @Override
    public void exportOrderInfo( OrderInfoRequest orderInfoRequest ) {
        final List<OrderInfo> list = orderInfoRepository
            .list(orderInfoRequest.queryWrapper());
        final List<ExportSheetDetail<OrderInfoExport, OrderInfo>> exportSheetDetails = new ArrayList<>();
        final ExportSheetDetail<OrderInfoExport, OrderInfo> exportExportSheetDetail =
            new ExportSheetDetail<>(OrderInfoExport.class, list, null, 1, 0);
        exportSheetDetails.add(exportExportSheetDetail);
        EasyExcelExecutor.exportMoreSheet("自己定义文件名称", exportSheetDetails);
    }
    
}