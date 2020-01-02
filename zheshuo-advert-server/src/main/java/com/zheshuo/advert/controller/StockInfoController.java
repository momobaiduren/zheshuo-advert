package com.zheshuo.advert.controller;


import com.zheshuo.advert.core.validation.ValidationManager;
import com.zheshuo.advert.service.StockInfoService;
import com.zheshuo.advert.request.StockInfoRequest;
import com.zheshuo.advert.response.StockInfoResponse;
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
 * (StockInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:53:24
 */
@RestController
@Api("")
@RequestMapping("/api/stockInfo")
public class StockInfoController {
    /**
     * 服务对象
     */
    @Resource
    private StockInfoService stockInfoService;

    /**
     * 分页查询所有数据
     * @param stockInfoRequest 查询条件
     * @return 分页查询
     */
    @GetMapping("/loadPage")
    @ApiOperation("条件分页查询数据")
    public OutputDTO<PageData<StockInfoResponse>> loadPage( @Validated @RequestBody StockInfoRequest stockInfoRequest)
        throws Exception {
        ValidationManager.validation(null).validateEntity(stockInfoRequest).consumer(validationEntityResult -> validationEntityResult.errorMsg());
       return stockInfoService.loadPage(stockInfoRequest);
    }


    /**
     * 查询列表
     *
     * @param stockInfoRequest 主键
     * @return 单条数据
     */
    @GetMapping("/loadList")
    @ApiOperation("条件列表查询数据")
    public OutputDTO<List<StockInfoResponse>> loadList(@Validated @RequestBody StockInfoRequest stockInfoRequest) {
        return stockInfoService.loadList(stockInfoRequest);
    }

    /**
     * 查询详情
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/loadDetail/{id}")
    @ApiOperation("id详情查询数据")
    public OutputDTO<StockInfoResponse> loadDetail(@PathVariable Serializable id) {
        return stockInfoService.loadDetail(id);
    }

    /**
     * 新增数据
     *
     * @param stockInfoRequest 查询条件
     * @return 新增结果
     */
    @PostMapping("/saveStockInfo")
    @ApiOperation("保存数据")
    public OutputDTO<Void> saveStockInfo(@Validated @RequestBody StockInfoRequest stockInfoRequest) {
        return stockInfoService.saveStockInfo(stockInfoRequest);
    }

    /**
     * 修改数据
     *
     * @param stockInfoRequest 查询条件
     * @return 修改结果
     */
    @PutMapping("/updateStockInfo")
    @ApiOperation("修改数据")
    public OutputDTO<Void> updateStockInfo(@Validated @RequestBody StockInfoRequest stockInfoRequest) {
        return  stockInfoService.updateStockInfo(stockInfoRequest);
    }
    
     /**
     * 导出
     * @param stockInfoRequest 查询条件
     */
    @GetMapping("/exportStockInfo")
    @ApiOperation("导出数据")
    public void exportStockInfo(@Validated @RequestBody StockInfoRequest stockInfoRequest ) {
        stockInfoService.exportStockInfo(stockInfoRequest);
    }
}