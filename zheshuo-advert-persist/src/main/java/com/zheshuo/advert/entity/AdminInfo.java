package com.zheshuo.advert.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户(AdminInfo)
 *
 * @author ZoneLen(张龙)
 * @since 2019-12-12 22:12:46
 */
@Data
@TableName("admin_info")
public class AdminInfo {
    //主键
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //状态
    private Integer state;
    //用户类型
    private Integer type;


}