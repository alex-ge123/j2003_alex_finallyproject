package com.qf.j2003.annotation;

import java.lang.annotation.*;

/**
 * Created by henry on 2020/10/19.
 */
//定义该注解用在方法前
@Target(ElementType.METHOD)
//定义注解的应用时期
@Retention(RetentionPolicy.RUNTIME)
//标识2该注解可以出现在自动文档中
@Documented
public @interface Log {
    //定义注解的属性
    public String name() default "";
}
