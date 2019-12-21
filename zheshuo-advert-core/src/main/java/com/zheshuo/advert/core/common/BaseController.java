package com.zheshuo.advert.core.common;


import com.zheshuo.advert.core.utils.WebUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * created by zhanglong and since  2019/12/12  10:58 上午
 *
 * @description: 描述
 */
public abstract class BaseController {

    private static final String SESSION_NAME = "username";

    private static final String LOGIN_TOKEN = "login-token";

    @PostMapping("/upload")
    public String upload( MultipartFile multipartFile){
        String url = null;

        //上传逻辑
        return url;
    }

    public void sessionUser(String userName){
        HttpSession session = WebUtils.getRequest().getSession();
        session.setAttribute(SESSION_NAME, userName);
        session.setMaxInactiveInterval(30);
    }

    public boolean isLogin(){
       return null != WebUtils.getRequest().getSession().getAttribute(SESSION_NAME);
    }

}
