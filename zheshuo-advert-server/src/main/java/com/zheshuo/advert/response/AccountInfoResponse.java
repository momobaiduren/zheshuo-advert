package com.zheshuo.advert.response;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 自定义demo表(AccountInfo)响应出参
 * @author ZhangLong
 * @since 2019-12-12 09:44:24
 */
@Data
@ApiModel("自定义demo表入参数据")
public class AccountInfoResponse {
    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("userName")
    private String userName;

    @ApiModelProperty("accountTotal")
    private Integer accountTotal;

    @ApiModelProperty("accountStatus")
    private Object accountStatus;

}