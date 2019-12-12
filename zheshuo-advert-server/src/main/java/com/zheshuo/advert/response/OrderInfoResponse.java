package com.zheshuo.advert.response;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * (OrderInfo)响应出参
 * @author ZhangLong
 * @since 2019-12-12 09:48:28
 */
@Data
@ApiModel("${tableInfo.obj.comment}入参数据")
public class OrderInfoResponse {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("orderNo")
    private String orderNo;

    @ApiModelProperty("productId")
    private Long productId;

    @ApiModelProperty("productCode")
    private String productCode;

    @ApiModelProperty("productNum")
    private Integer productNum;

    @ApiModelProperty("productTotal")
    private Integer productTotal;

    @ApiModelProperty("productPrice")
    private Integer productPrice;

    @ApiModelProperty("userName")
    private String userName;

}