package com.qianfeng.j2003.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Component
@Aspect
public class MyAop {
    @Pointcut("execution(* com.qianfeng.j2003.controller..*.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("xxxxx");
    }
}
