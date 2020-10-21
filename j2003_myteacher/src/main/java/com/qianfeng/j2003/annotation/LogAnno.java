package com.qianfeng.j2003.annotation;

import java.lang.annotation.*;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
//使用target元注解定义次注解只能在方法前生效
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//是否生成自动文档
@Documented
public @interface LogAnno {
    //定义name属性描述某方法
    public String name() default "";
}
