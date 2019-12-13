package com.zheshuo.advert.core.cache;

/**
 * created by zhanglong and since  2019/12/12  6:32 下午
 *
 * @description: 描述
 */
public class UserContext {
    private static ThreadLocal<AdminLoginCache.SecurityUser> securityUserThreadLocal = new ThreadLocal<>();

    public static void save(String token, AdminLoginCache adminLoginCache){
        AdminLoginCache.SecurityUser securityUser = adminLoginCache.getUser(token);
        securityUserThreadLocal.set(securityUser);
    }

    public static AdminLoginCache.SecurityUser getSecurityUser(){
        return securityUserThreadLocal.get();
    }
}
