package com.zheshuo.advert.response;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户(AdminInfo)响应出参
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
@Data
@ApiModel("用户入参数据")
public class AdminInfoResponse {
    /**
      * 主键
      */
    @ApiModelProperty("主键")
    private Long id;

    /**
      * 用户名
      */
    @ApiModelProperty("用户名")
    private String username;

    /**
      * 密码
      */
    @ApiModelProperty("密码")
    private String password;

    /**
      * 状态
      */
    @ApiModelProperty("状态")
    private Integer state;

    /**
      * 用户类型
      */
    @ApiModelProperty("用户类型")
    private Integer type;

}