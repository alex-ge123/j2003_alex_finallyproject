package com.qf.j2003.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import java.util.Arrays;
import org.springframework.stereotype.Component;

/**
 * Created by henry on 2020/10/19.
 */
@Component
@Aspect
@Slf4j   //启动日志对象
public class SyslogAspect {
    @Pointcut("execution(public * com.qf.j2003.controller..*(..))")
    public void pointcut1(){}

    //声明一定前置通知@Before
    @Before("pointcut1()")
    public void before(JoinPoint point){
        //获取切点的方法名
        String methodname = point.getSignature().getName();
        //获取切点方法的类名
        String classname = point.getTarget().getClass().getName();
        //获取切点方法的参数字符串
        String argsName =  Arrays.toString(point.getArgs());
        log.info("类名: {},方法: {},参数: {}",classname,methodname,argsName);
    }
}
