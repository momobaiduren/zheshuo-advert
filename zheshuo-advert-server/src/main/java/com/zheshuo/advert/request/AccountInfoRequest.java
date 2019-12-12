package com.zheshuo.advert.request;

import lombok.Data;
import com.zheshuo.advert.common.BaseRequest;
import com.zheshuo.advert.entity.AccountInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 自定义demo表(AccountInfo)请求入参
 * @author ZhangLong
 * @since 2019-12-12 10:51:25
 */
@Data
@ApiModel("自定义demo表入参数据")
public class AccountInfoRequest extends BaseRequest {
    @ApiModelProperty("id")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Long id;
        
    @ApiModelProperty("userName")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String userName;
        
    @ApiModelProperty("accountTotal")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer accountTotal;
        
    @ApiModelProperty("accountStatus")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer accountStatus;
        
    public QueryWrapper<AccountInfo> queryWrapper() {
        QueryWrapper<AccountInfo> queryWrapper = new QueryWrapper<>();
            if (Objects.nonNull(id)) {
            queryWrapper.eq("id", id);
        }
            if (Objects.nonNull(userName)) {
            queryWrapper.eq("user_name", userName);
        }
            if (Objects.nonNull(accountTotal)) {
            queryWrapper.eq("account_total", accountTotal);
        }
            if (Objects.nonNull(accountStatus)) {
            queryWrapper.eq("account_status", accountStatus);
        }
            return queryWrapper;
    }

    
}