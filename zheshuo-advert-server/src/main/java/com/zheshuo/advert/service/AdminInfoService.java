package com.zheshuo.advert.service;

import com.zheshuo.advert.request.AdminInfoLoginRequest;
import com.zheshuo.advert.request.AdminInfoRequest;
import com.zheshuo.advert.response.AdminInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import java.io.Serializable;
import java.util.List;
/**
 * 用户(AdminInfo)表服务接口
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
public interface AdminInfoService{
    /**
     * @param adminInfoRequest  入参条件
     * @return  PageOutputDTO<AdminInfoResponse>
     */
    OutputDTO<PageData<AdminInfoResponse>> loadPage( AdminInfoRequest adminInfoRequest );
    
    /**
     * @param adminInfoRequest  入参条件
     * @return  OutputDTO<List<AdminInfoResponse>>
     */
    OutputDTO<List<AdminInfoResponse>> loadList( AdminInfoRequest adminInfoRequest );
    
    /**
     * @param id  主键
     * @return  OutputDTO<AdminInfoResponse>
     */
    OutputDTO<AdminInfoResponse> loadDetail( Serializable id );
    
    /**
     * @param adminInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    OutputDTO<Void> saveAdminInfo( AdminInfoRequest adminInfoRequest );
    
    /**
     * @param adminInfoRequest  入参条件
     * @return  OutputDTO<Void>
     */
    
    OutputDTO<Void> updateAdminInfo(AdminInfoRequest adminInfoRequest );
    
    /**
     * @param adminInfoRequest 入参条件
     */
    void exportAdminInfo( AdminInfoRequest adminInfoRequest );

    OutputDTO<Void> login( AdminInfoLoginRequest adminInfoLoginRequest );

    OutputDTO<Void> loginOut();
}