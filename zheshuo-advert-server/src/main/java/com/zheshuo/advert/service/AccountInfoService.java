package com.zheshuo.advert.service;

import com.zheshuo.advert.core.common.PageData;
import com.zheshuo.advert.request.AccountInfoRequest;
import com.zheshuo.advert.response.AccountInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import java.io.Serializable;
import java.util.List;
/**
 * 自定义demo表(AccountInfo)表服务接口
 * @author ZhangLong
 * @since 2019-12-12 09:39:58
 */
public interface AccountInfoService{
    /**
     * @param accountInfoRequest  入参条件
     * @return  PageOutputDTO<AccountInfoResponse>
     */
    OutputDTO<PageData<AccountInfoResponse>> loadPage( AccountInfoRequest accountInfoRequest );
    
    /**
     * @param accountInfoRequest  入参条件
     * @return  OutputDTO<List<AccountInfoResponse>>
     */
    OutputDTO<List<AccountInfoResponse>> loadList( AccountInfoRequest accountInfoRequest );
    
    /**
     * @param id  主键
     * @return  OutputDTO<AccountInfoResponse>
     */
    OutputDTO<AccountInfoResponse> loadDetail( Serializable id );
    
    /**
     * @param accountInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    OutputDTO<Void> saveAccountInfo( AccountInfoRequest accountInfoRequest );
    
    /**
     * @param accountInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    
    OutputDTO<Void> updateAccountInfo(AccountInfoRequest accountInfoRequest );
    
    /**
     * @param accountInfoRequest 入参条件
     */
    void exportAccountInfo( AccountInfoRequest accountInfoRequest );
}