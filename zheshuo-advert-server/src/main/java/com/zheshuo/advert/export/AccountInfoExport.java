package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.ExcelModel;
import lombok.Data;

/**
 * 自定义demo表(AccountInfo)
 * @author ZhangLong
 * @since 2019-12-12 09:40:06
 */

@Data
public class AccountInfoExport implements ExcelModel{
    @ExcelProperty("id")
    private Long id;
    
    @ExcelProperty("userName")
    private String userName;
    
    @ExcelProperty("accountTotal")
    private Integer accountTotal;
    
    @ExcelProperty("accountStatus")
    private Object accountStatus;
    
}