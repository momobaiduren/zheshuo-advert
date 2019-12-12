package com.zheshuo.advert.core.filter;

import com.alibaba.fastjson.JSON;
import com.zheshuo.advert.core.cache.AdminLoginCache;
import com.zheshuo.advert.core.cache.AdminLoginCache.SecurityUser;
import com.zheshuo.advert.core.cache.UserContext;
import com.zheshuo.advert.core.common.OutputDTO;
import com.zheshuo.advert.core.utils.WebUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * created by zhanglong and since  2019/11/26  5:33 下午
 *
 * @description: 描述
 */
@Order(1)
@Component
@WebFilter(filterName = "webServerFilter")
public class WebServerFilter implements Filter {

    private static final String LOGIN_TOKEN = "login-token";
    private static final String ENCODE = "UTF-8";

    private static final String[] FILTERPATH = {"/api/"};
    @Resource
    private AdminLoginCache adminLoginCache;

    private boolean isFilter( String requestUrl ) {
        if (FILTERPATH != null) {
            for (String exclusion : FILTERPATH) {
                if (!exclusion.startsWith("/")) {
                    exclusion = "/" + exclusion;
                }
                if (requestUrl.startsWith(exclusion)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void init( FilterConfig filterConfig ) throws ServletException {
        filterConfig.getServletContext().setRequestCharacterEncoding(ENCODE);
        filterConfig.getServletContext().setResponseCharacterEncoding(ENCODE);
    }

    @Override
    public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 如果是OPTIONS则结束请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        final String servletPath = request.getServletPath();
        if (isFilter(servletPath)) {
            setupResponseHeader(request, response);
            handlerToken(request, response);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }

    private void handlerToken( HttpServletRequest request, HttpServletResponse response ) {
        final String token = request.getHeader(LOGIN_TOKEN);
        if (StringUtils.isNotBlank(token)){
            UserContext.save(token, adminLoginCache);
            WebUtils.bindContext(request, response);
        }
    }

    private void setupResponseHeader( HttpServletRequest request, HttpServletResponse response ) {
        String origin = request.getHeader("Origin");
        if (origin != null) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        } else {
            response.setHeader("Access-Control-Allow-Origin", "*");
        }
        response.setHeader("Access-Control-Allow-Headers",
            "origin, content-type, accept, authorization, " + LOGIN_TOKEN);
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition, " + LOGIN_TOKEN);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Methods",
            "GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH");
        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            response.setStatus(204);
        }
    }
}
