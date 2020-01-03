package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.AbstractExcelModel;
import lombok.Data;

/**
 * (OrderInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:52:58
 */

@Data
public class OrderInfoExport extends AbstractExcelModel {
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