package com.zheshuo.advert.cache;

import com.zheshuo.advert.core.utils.WebUtils;
import com.zheshuo.advert.entity.AdminInfo;
import java.util.Objects;

/**
 * created by zhanglong and since  2019/12/12  6:32 下午
 *
 * @description: 描述
 */
public class UserContext {
    private static final String SESSION_NAME = "username";

    private static ThreadLocal<AdminInfo> SECURITY_USER_CACHE = new ThreadLocal<>();

    public static boolean checkToken(){
        Object securityUser = Objects.requireNonNull(WebUtils.getRequest()).getSession().getAttribute(SESSION_NAME);
        if (null != securityUser){
            AdminInfo adminInfo = (AdminInfo) securityUser;
            SECURITY_USER_CACHE.set(adminInfo);
            return true;
        }
        return false;
    }

    public static void register(AdminInfo adminInfo){
        Objects.requireNonNull(WebUtils.getRequest())
            .getSession().setAttribute(SESSION_NAME, adminInfo);
    }

    public static void removeLogin(){
        Objects.requireNonNull(WebUtils.getRequest()).getSession().invalidate();
    }

    public static AdminInfo getSecurityUser(){
        return SECURITY_USER_CACHE.get();
    }
    /**
     * description 线程结束调用避免内存泄漏
     */
    public void clear(){
        SECURITY_USER_CACHE.remove();
        SECURITY_USER_CACHE = null;
    }
}
