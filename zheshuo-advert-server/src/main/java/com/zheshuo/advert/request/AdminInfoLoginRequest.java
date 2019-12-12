package com.zheshuo.advert.request;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zheshuo.advert.entity.AdminInfo;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 * created by zhanglong and since  2019/12/12  3:57 下午
 *
 * @description: 描述
 */
@Data
public class AdminInfoLoginRequest {
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    public QueryWrapper<AdminInfo> queryWrapper() {
        QueryWrapper<AdminInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("password", password);
        return queryWrapper;
    }
}
