package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.AbstractExcelModel;
import lombok.Data;

/**
 * (StockInfo)
 *
 * @author ZhangLong
 * @since 2019-12-12 10:53:26
 */

@Data
public class StockInfoExport extends AbstractExcelModel {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("stockNum")
    private Integer stockNum;

    @ExcelProperty("productId")
    private Long productId;

}