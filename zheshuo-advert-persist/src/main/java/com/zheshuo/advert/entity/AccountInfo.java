package com.zheshuo.advert.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
/**
 * 自定义demo表(AccountInfo)
 * @author ZhangLong
 * @since 2019-12-12 10:54:54
 */
@Data
@TableName("account_info")
public class AccountInfo {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    
    private String userName;
    
    private Integer accountTotal;
    
    private Integer accountStatus;
    
}