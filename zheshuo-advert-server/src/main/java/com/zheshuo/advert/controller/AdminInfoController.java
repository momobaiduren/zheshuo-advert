package com.zheshuo.advert.controller;


import com.zheshuo.advert.request.AdminInfoLoginRequest;
import com.zheshuo.advert.response.AdminInfoLoginResponse;
import com.zheshuo.advert.service.AdminInfoService;
import com.zheshuo.advert.request.AdminInfoRequest;
import com.zheshuo.advert.response.AdminInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import org.springframework.validation.annotation.Validated;
import com.zheshuo.advert.core.common.BaseController;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 用户(AdminInfo)
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
@RestController
@Api("用户")
@RequestMapping("/api/adminInfo")
public class AdminInfoController extends BaseController{
    /**
     * 服务对象
     */
    @Resource
    private AdminInfoService adminInfoService;

    /**
     * 分页查询所有数据
     * @param adminInfoRequest 查询条件
     * @return 分页查询
     */
    @GetMapping("/loadPage")
    @ApiOperation("条件分页查询用户数据")
    public OutputDTO<PageData<AdminInfoResponse>> loadPage( @Validated @RequestBody AdminInfoRequest adminInfoRequest){
       return adminInfoService.loadPage(adminInfoRequest);
    }


    /**
     * 查询列表
     *
     * @param adminInfoRequest 主键
     * @return 单条数据
     */
    @GetMapping("/loadList")
    @ApiOperation("条件列表查询用户数据")
    public OutputDTO<List<AdminInfoResponse>> loadList(@Validated @RequestBody AdminInfoRequest adminInfoRequest) {
        return adminInfoService.loadList(adminInfoRequest);
    }

    @GetMapping("/loginOut/")
    @ApiOperation("退出登陆")
    public OutputDTO<Void> loginOut() {
        return adminInfoService.loginOut();
    }

    /**
     * 查询详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/loadDetail/{id}")
    @ApiOperation("id详情查询用户数据")
    public OutputDTO<AdminInfoResponse> loadDetail(@PathVariable Serializable id) {
        return adminInfoService.loadDetail(id);
    }

    /**
     * 新增数据
     *
     * @param adminInfoRequest 查询条件
     * @return 新增结果
     */
    @PostMapping("/register")
    @ApiOperation("注册用户数据")
    public OutputDTO<Void> saveAdminInfo(@Validated @RequestBody AdminInfoRequest adminInfoRequest) {
        return adminInfoService.saveAdminInfo(adminInfoRequest);
    }

    /**
     * 修改数据
     *
     * @param adminInfoRequest 查询条件
     * @return 修改结果
     */
    @PutMapping("/updateAdminInfo")
    @ApiOperation("修改用户数据")
    public OutputDTO<Void> updateAdminInfo(@Validated @RequestBody AdminInfoRequest adminInfoRequest) {
        return  adminInfoService.updateAdminInfo(adminInfoRequest);
    }
    
     /**
     * 导出
     * @param adminInfoRequest 查询条件
     */
    @GetMapping("/exportAdminInfo")
    @ApiOperation("导出用户数据")
    public void exportAdminInfo(@Validated @RequestBody AdminInfoRequest adminInfoRequest ) {
        adminInfoService.exportAdminInfo(adminInfoRequest);
    }
}