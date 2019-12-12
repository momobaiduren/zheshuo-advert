package com.zheshuo.advert.service;

import com.zheshuo.advert.request.StockInfoRequest;
import com.zheshuo.advert.response.StockInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import java.io.Serializable;
import java.util.List;
/**
 * (StockInfo)表服务接口
 * @author ZhangLong
 * @since 2019-12-12 10:53:24
 */
public interface StockInfoService{
    /**
     * @param stockInfoRequest  入参条件
     * @return  PageOutputDTO<StockInfoResponse>
     */
    OutputDTO<PageData<StockInfoResponse>> loadPage( StockInfoRequest stockInfoRequest );
    
    /**
     * @param stockInfoRequest  入参条件
     * @return  OutputDTO<List<StockInfoResponse>>
     */
    OutputDTO<List<StockInfoResponse>> loadList( StockInfoRequest stockInfoRequest );
    
    /**
     * @param id  主键
     * @return  OutputDTO<StockInfoResponse>
     */
    OutputDTO<StockInfoResponse> loadDetail( Serializable id );
    
    /**
     * @param stockInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    OutputDTO<Void> saveStockInfo( StockInfoRequest stockInfoRequest );
    
    /**
     * @param stockInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    
    OutputDTO<Void> updateStockInfo(StockInfoRequest stockInfoRequest );
    
    /**
     * @param stockInfoRequest 入参条件
     */
    void exportStockInfo( StockInfoRequest stockInfoRequest );
}