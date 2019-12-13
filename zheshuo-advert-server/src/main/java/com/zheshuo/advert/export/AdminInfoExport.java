package com.zheshuo.advert.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.zheshuo.advert.core.easyexcel.ExcelModel;
import lombok.Data;

/**
 * 用户(AdminInfo)
 * @author ZhangLong
 * @since 2019-12-12 15:55:44
 */

@Data
public class AdminInfoExport implements ExcelModel{
    /**
     *主键
     */
    @ExcelProperty("主键")
    private Long id;
    
    /**
     *用户名
     */
    @ExcelProperty("用户名")
    private String username;
    
    /**
     *密码
     */
    @ExcelProperty("密码")
    private String password;
    
    /**
     *状态
     */
    @ExcelProperty("状态")
    private Integer state;
    
    /**
     *用户类型
     */
    @ExcelProperty("用户类型")
    private Integer type;
    
}