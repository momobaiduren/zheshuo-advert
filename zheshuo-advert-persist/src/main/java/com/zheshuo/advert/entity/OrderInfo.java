package com.zheshuo.advert.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zheshuo.advert.core.easyexcel.ExcelModel;

import lombok.Data;
/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:47:25
 */
@Data
@TableName("order_info")
public class OrderInfo implements ExcelModel {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private String orderNo;
    
    private Long productId;
    
    private String productCode;
    
    private Integer productNum;
    
    private Integer productTotal;
    
    private Integer productPrice;
    
    private String userName;
    
}