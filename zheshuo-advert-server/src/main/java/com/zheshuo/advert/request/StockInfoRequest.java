package com.zheshuo.advert.request;

import lombok.Data;
import com.zheshuo.advert.common.BaseRequest;
import com.zheshuo.advert.entity.StockInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * (StockInfo)请求入参
 * @author ZhangLong
 * @since 2019-12-12 10:53:24
 */
@Data
@ApiModel("${tableInfo.obj.comment}入参数据")
public class StockInfoRequest extends BaseRequest {
    @ApiModelProperty("id")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Long id;
        
    @ApiModelProperty("stockNum")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Integer stockNum;
        
    @ApiModelProperty("productId")
    @NotNull(message = "校验错误信息->可以使用javax对应的其他注解:正则，正负值等")
    private Long productId;
        
    @Override
    public QueryWrapper<StockInfo> queryWrapper() {
        QueryWrapper<StockInfo> queryWrapper = new QueryWrapper<>();
            if (Objects.nonNull(id)) {
            queryWrapper.eq("id", id);
        }
            if (Objects.nonNull(stockNum)) {
            queryWrapper.eq("stock_num", stockNum);
        }
            if (Objects.nonNull(productId)) {
            queryWrapper.eq("product_id", productId);
        }
            return queryWrapper;
    }

    
}