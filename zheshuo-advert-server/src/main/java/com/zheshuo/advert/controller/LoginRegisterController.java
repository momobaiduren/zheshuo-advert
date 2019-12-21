package com.zheshuo.advert.controller;


import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.entity.AdminInfo;
import com.zheshuo.advert.request.AdminInfoLoginRequest;
import com.zheshuo.advert.request.AdminInfoRequest;
import com.zheshuo.advert.response.AdminInfoResponse;
import com.zheshuo.advert.service.AdminInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


/**
 * 用户(AdminInfo)
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
@RestController
@Api("登陆注册")
@RequestMapping("/web")
public class LoginRegisterController{
    /**
     * 服务对象
     */
    @Resource
    private AdminInfoService adminInfoService;


    /**
     * 查询详情
     * @param adminInfoLoginRequest 主键
     * @return 单条数据
     */
    @PostMapping("/login")
    @ApiOperation("登陆")
    public OutputDTO<Void> login(@Validated @RequestBody AdminInfoLoginRequest adminInfoLoginRequest) {
        return adminInfoService.login(adminInfoLoginRequest);
    }

    @PostMapping("/register/")
    @ApiOperation("注册")
    public OutputDTO<Void> register(@Validated @RequestBody AdminInfoRequest adminInfoRequest) {
        return adminInfoService.register(adminInfoRequest);
    }

}