package com.zheshuo.advert.request;

import com.zheshuo.advert.core.validation.ValidationManager;
import lombok.Data;
import com.zheshuo.advert.common.BaseRequest;
import com.zheshuo.advert.entity.AdminInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户(AdminInfo)请求入参
 *
 * @author ZhangLong
 * @since 2019-12-12 15:55:43
 */
@Data
@ApiModel("用户入参数据")
public class AdminInfoRequest extends BaseRequest {

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String password;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer state;

    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer type;

    @Override
    public QueryWrapper<AdminInfo> queryWrapper() {
        QueryWrapper<AdminInfo> queryWrapper = new QueryWrapper<>();
        if (Objects.nonNull(id)) {
            queryWrapper.eq("id", id);
        }
        if (Objects.nonNull(username)) {
            queryWrapper.eq("username", username);
        }
        if (Objects.nonNull(password)) {
            queryWrapper.eq("password", password);
        }
        if (Objects.nonNull(state)) {
            queryWrapper.eq("state", state);
        }
        if (Objects.nonNull(type)) {
            queryWrapper.eq("type", type);
        }
        return queryWrapper;
    }


//    public static void main( String[] args ) throws Exception {
//        ValidationManager.validation(IllegalArgumentException::new)
//            .validateEntity(new AdminInfoRequest())
//            .consumer(validationEntityResult -> System.out.println(validationEntityResult.errorMsg())
//        );
//    }

}