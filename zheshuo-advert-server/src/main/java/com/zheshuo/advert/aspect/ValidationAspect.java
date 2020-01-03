package com.zheshuo.advert.aspect;

import com.alibaba.fastjson.JSON;
import com.zheshuo.advert.core.exception.BizException;
import com.zheshuo.advert.core.utils.WebUtils;
import com.zheshuo.advert.core.validation.ValidationManager;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * created by zhanglong and since  2019/11/13  6:31 下午
 *
 * @description: 统一处理
 */
@Slf4j
@Aspect
@Component
public class ValidationAspect {

    @Pointcut("@annotation(ValidationAnnocation)")
    public void validationPointcut() {
    }
    @Before(value = "validationPointcut()")
    public void mybatisPlusOperationFailHandler( JoinPoint joinPoint ) {
        final Object[] args = joinPoint.getArgs();
        if (null != args && args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                ValidationManager.validation(BizException::new).validateEntity(args[i]);
            }

        }
    }


}
