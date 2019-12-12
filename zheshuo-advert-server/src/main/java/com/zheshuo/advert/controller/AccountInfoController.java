package com.zheshuo.advert.controller;


import com.zheshuo.advert.core.common.BaseController;
import com.zheshuo.advert.service.AccountInfoService;
import com.zheshuo.advert.request.AccountInfoRequest;
import com.zheshuo.advert.response.AccountInfoResponse;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.common.PageData;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * 自定义demo表(AccountInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:51:24
 */
@RestController
@Api("自定义demo表")
@RequestMapping("/api/accountInfo")
public class AccountInfoController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private AccountInfoService accountInfoService;

    /**
     * 分页查询所有数据
     * @param accountInfoRequest 查询条件
     * @return 分页查询
     */
    @GetMapping("/loadPage")
    @ApiOperation("条件分页查询自定义demo表数据")
    public OutputDTO<PageData<AccountInfoResponse>> loadPage( @Validated @RequestBody AccountInfoRequest accountInfoRequest){
       return accountInfoService.loadPage(accountInfoRequest);
    }


    /**
     * 查询列表
     *
     * @param accountInfoRequest 主键
     * @return 单条数据
     */
    @GetMapping("/loadList")
    @ApiOperation("条件列表查询自定义demo表数据")
    public OutputDTO<List<AccountInfoResponse>> loadList(@Validated @RequestBody AccountInfoRequest accountInfoRequest) {
        return accountInfoService.loadList(accountInfoRequest);
    }

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/loadDetail/{id}")
    @ApiOperation("id详情查询自定义demo表数据")
    public OutputDTO<AccountInfoResponse> loadDetail(@PathVariable Serializable id) {
        return accountInfoService.loadDetail(id);
    }

    /**
     * 新增数据
     *
     * @param accountInfoRequest 查询条件
     * @return 新增结果
     */
    @PostMapping("/saveAccountInfo")
    @ApiOperation("保存自定义demo表数据")
    public OutputDTO<Void> saveAccountInfo(@Validated @RequestBody AccountInfoRequest accountInfoRequest) {
        return accountInfoService.saveAccountInfo(accountInfoRequest);
    }

    /**
     * 修改数据
     *
     * @param accountInfoRequest 查询条件
     * @return 修改结果
     */
    @PutMapping("/updateAccountInfo")
    @ApiOperation("修改自定义demo表数据")
    public OutputDTO<Void> updateAccountInfo(@Validated @RequestBody AccountInfoRequest accountInfoRequest) {
        return  accountInfoService.updateAccountInfo(accountInfoRequest);
    }
    
     /**
     * 导出
     * @param accountInfoRequest 查询条件
     */
    @GetMapping("/exportAccountInfo")
    @ApiOperation("导出自定义demo表数据")
    public void exportAccountInfo(@Validated @RequestBody AccountInfoRequest accountInfoRequest ) {
        accountInfoService.exportAccountInfo(accountInfoRequest);
    }
}