package com.zheshuo.advert.cache;

import com.zheshuo.advert.core.utils.WebUtils;
import com.zheshuo.advert.entity.AdminInfo;

/**
 * created by zhanglong and since  2019/12/12  6:32 下午
 *
 * @description: 描述
 */
public class UserContext {
    private static final String SESSION_NAME = "username";

    private static ThreadLocal<AdminInfo> securityUserThreadLocal = new ThreadLocal<>();

    public static boolean checkToken(){
        Object securityUser = WebUtils.getRequest().getSession().getAttribute(SESSION_NAME);
        if (null != securityUser){
            AdminInfo adminInfo = (AdminInfo) securityUser;
            securityUserThreadLocal.set(adminInfo);
            return true;
        }
        return false;
    }

    public static void register(AdminInfo adminInfo){
        WebUtils.getRequest().getSession().setAttribute(SESSION_NAME, adminInfo);
    }

    public static void removeLogin(){
        WebUtils.getRequest().getSession().invalidate();
    }

    public static AdminInfo getSecurityUser(){
        return securityUserThreadLocal.get();
    }
}
