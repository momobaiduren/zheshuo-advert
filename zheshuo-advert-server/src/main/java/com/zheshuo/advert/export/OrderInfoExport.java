package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.ExcelModel;
import lombok.Data;

/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:48:28
 */

@Data
public class OrderInfoExport implements ExcelModel{
    @ExcelProperty("id")
    private Long id;
    
    @ExcelProperty("orderNo")
    private String orderNo;
    
    @ExcelProperty("productId")
    private Long productId;
    
    @ExcelProperty("productCode")
    private String productCode;
    
    @ExcelProperty("productNum")
    private Integer productNum;
    
    @ExcelProperty("productTotal")
    private Integer productTotal;
    
    @ExcelProperty("productPrice")
    private Integer productPrice;
    
    @ExcelProperty("userName")
    private String userName;
    
}