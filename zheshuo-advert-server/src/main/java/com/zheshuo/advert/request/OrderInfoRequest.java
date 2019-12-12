package com.zheshuo.advert.request;

import lombok.Data;
import com.zheshuo.advert.common.BaseRequest;
import com.zheshuo.advert.entity.OrderInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * (OrderInfo)请求入参
 * @author ZhangLong
 * @since 2019-12-12 10:52:56
 */
@Data
@ApiModel("${tableInfo.obj.comment}入参数据")
public class OrderInfoRequest extends BaseRequest {
    @ApiModelProperty("id")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Long id;
        
    @ApiModelProperty("orderNo")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String orderNo;
        
    @ApiModelProperty("productId")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Long productId;
        
    @ApiModelProperty("productCode")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String productCode;
        
    @ApiModelProperty("productNum")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer productNum;
        
    @ApiModelProperty("productTotal")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer productTotal;
        
    @ApiModelProperty("productPrice")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer productPrice;
        
    @ApiModelProperty("userName")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private String userName;
        
    @Override
    public QueryWrapper<OrderInfo> queryWrapper() {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<>();
            if (Objects.nonNull(id)) {
            queryWrapper.eq("id", id);
        }
            if (Objects.nonNull(orderNo)) {
            queryWrapper.eq("order_no", orderNo);
        }
            if (Objects.nonNull(productId)) {
            queryWrapper.eq("product_id", productId);
        }
            if (Objects.nonNull(productCode)) {
            queryWrapper.eq("product_code", productCode);
        }
            if (Objects.nonNull(productNum)) {
            queryWrapper.eq("product_num", productNum);
        }
            if (Objects.nonNull(productTotal)) {
            queryWrapper.eq("product_total", productTotal);
        }
            if (Objects.nonNull(productPrice)) {
            queryWrapper.eq("product_price", productPrice);
        }
            if (Objects.nonNull(userName)) {
            queryWrapper.eq("user_name", userName);
        }
            return queryWrapper;
    }

    
}