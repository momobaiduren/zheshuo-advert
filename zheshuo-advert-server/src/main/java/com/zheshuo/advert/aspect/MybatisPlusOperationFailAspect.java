package com.zheshuo.advert.aspect;

import com.alibaba.fastjson.JSON;
import com.zheshuo.advert.core.exception.BizException;
import com.zheshuo.advert.core.utils.WebUtils;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * created by zhanglong and since  2019/11/13  6:31 下午
 * @description: 统一处理
 */
@Slf4j
@Aspect
@Component
public class MybatisPlusOperationFailAspect {

    @Pointcut("execution(* com.baomidou.mybatisplus.extension.service.IService.save*(..))"
        + "|| execution(* com.baomidou.mybatisplus.extension.service.IService.update*(..))"
        + "|| execution(* com.baomidou.mybatisplus.extension.service.IService.remove*(..))")
    public void mybatisRepositoryPointcut() {
    }

    @AfterReturning(value = "mybatisRepositoryPointcut()", returning = "returnVal")
    public void mybatisPlusOperationFailHandler( boolean returnVal ) {
        HttpServletRequest request = WebUtils.getRequest();
        if (!returnVal) {
            assert request != null;
            log.error("接口地址：{}", request.getServletPath());
            log.error("接口请求参数:{}", JSON.toJSONString(request.getParameterMap()));
            throw new BizException("数据提交操作未成功");
        }
    }


}
