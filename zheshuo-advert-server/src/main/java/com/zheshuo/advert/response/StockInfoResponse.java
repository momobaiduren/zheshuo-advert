package com.zheshuo.advert.response;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (StockInfo)响应出参
 * @author ZhangLong
 * @since 2019-12-12 10:53:24
 */
@Data
@ApiModel("${tableInfo.obj.comment}入参数据")
public class StockInfoResponse {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("stockNum")
    private Integer stockNum;

    @ApiModelProperty("productId")
    private Long productId;

}