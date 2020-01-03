package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.AbstractExcelModel;
import lombok.Data;

/**
 * 自定义demo表(AccountInfo)
 *
 * @author ZhangLong
 * @since 2019-12-12 10:51:27
 */

@Data
public class AccountInfoExport extends AbstractExcelModel {

    @ExcelProperty("id")
    private Long id;

    @ExcelProperty("userName")
    private String userName;

    @ExcelProperty("accountTotal")
    private Integer accountTotal;

    @ExcelProperty("accountStatus")
    private Integer accountStatus;

}