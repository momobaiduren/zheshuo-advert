package com.zheshuo.advert.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhanglong
 * @since 2020/1/2  7:05 下午
 */
//声明注解的使用位置:成员方法上
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationAnnocation {

}
