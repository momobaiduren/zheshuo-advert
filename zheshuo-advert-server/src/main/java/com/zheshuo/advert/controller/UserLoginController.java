package com.zheshuo.advert.controller;


import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.response.OrderInfoResponse;
import com.zheshuo.advert.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.io.Serializable;


/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:52:56
 */
@RestController
@Api("用户登陆")
@RequestMapping("/web")
public class UserLoginController {
    /**
     * 服务对象
     */
    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 查询详情
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/login")
    @ApiOperation("id详情查询数据")
    public OutputDTO<OrderInfoResponse> login(@PathVariable Serializable id) {
        return orderInfoService.loadDetail(id);
    }

}