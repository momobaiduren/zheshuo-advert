package com.zheshuo.advert.service;

import com.zheshuo.advert.request.OrderInfoRequest;
import com.zheshuo.advert.response.OrderInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import java.io.Serializable;
import java.util.List;
/**
 * (OrderInfo)表服务接口
 * @author ZhangLong
 * @since 2019-12-12 10:52:56
 */
public interface OrderInfoService{
    /**
     * @param orderInfoRequest  入参条件
     * @return  PageOutputDTO<OrderInfoResponse>
     */
    OutputDTO<PageData<OrderInfoResponse>> loadPage( OrderInfoRequest orderInfoRequest );
    
    /**
     * @param orderInfoRequest  入参条件
     * @return  OutputDTO<List<OrderInfoResponse>>
     */
    OutputDTO<List<OrderInfoResponse>> loadList( OrderInfoRequest orderInfoRequest );
    
    /**
     * @param id  主键
     * @return  OutputDTO<OrderInfoResponse>
     */
    OutputDTO<OrderInfoResponse> loadDetail( Serializable id );
    
    /**
     * @param orderInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    OutputDTO<Void> saveOrderInfo( OrderInfoRequest orderInfoRequest );
    
    /**
     * @param orderInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    
    OutputDTO<Void> updateOrderInfo(OrderInfoRequest orderInfoRequest );
    
    /**
     * @param orderInfoRequest 入参条件
     */
    void exportOrderInfo( OrderInfoRequest orderInfoRequest );
}