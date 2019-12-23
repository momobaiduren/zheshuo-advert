package com.zheshuo.advert.request;

import lombok.Data;
import com.zheshuo.advert.dao.model.entity.AdminInfoDO;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.plugins.Page;
/**
 * 用户请求入参
 * @author ZhangLong
 * @since 2019-12-22 00:51:04
 */
@Data
@ApiModel("用户入参数据")
public class AdminInfoRequest {
    /**
      * 主键
      */
    @ApiModelProperty("主键")
    @NotNull(message = "主键不能为空")
    private Long id;
        
    /**
      * 用户名
      */
    @ApiModelProperty("用户名")
    @NotNull(message = "用户名不能为空")
    private String username;
        
    /**
      * 密码
      */
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空")
    private String password;
        
    /**
      * 状态
      */
    @ApiModelProperty("状态")
    @NotNull(message = "状态不能为空")
    private Integer state;
        
    /**
      * 用户类型
      */
    @ApiModelProperty("用户类型")
    @NotNull(message = "用户类型不能为空")
    private Integer type;
        
    public EntityWrapper<AdminInfoDO> queryWrapper() {
        EntityWrapper<AdminInfoDO> ew = new EntityWrapper<>();
            if (Objects.nonNull(id)) {
            ew.eq("id", id);
        }
            if (Objects.nonNull(username)) {
            ew.eq("username", username);
        }
            if (Objects.nonNull(password)) {
            ew.eq("password", password);
        }
            if (Objects.nonNull(state)) {
            ew.eq("state", state);
        }
            if (Objects.nonNull(type)) {
            ew.eq("type", type);
        }
            return ew;
    }
    
    /**
     * description 默认是1
     */
    private int current;
    /**
     * description 默认是10
     */
    private int size;

    public Page<AdminInfoDO> page() {
        return new Page<>(current, size);
    }
    
}