package com.zheshuo.advert.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * (StockInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:55:01
 */
@Data
@TableName("stock_info")
public class StockInfo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private Integer stockNum;
    
    private Long productId;
    
}