package com.qianfeng.j2003.aop;

import com.qianfeng.j2003.annotation.LogAnno;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
//    @Pointcut("@annotation(com.qianfeng.j2003.annotation.LogAnno)")
//    public void pointCut(){}
//
//    @Around("pointCut()")
//    public Object around(ProceedingJoinPoint joinPoint){
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        String methodName = methodSignature.getName();  //获取方法名
//        System.out.println("LogAspect:   "+ methodName);
//        //        获取方法前指定的注解
//        LogAnno annotation = methodSignature.getMethod().getAnnotation(LogAnno.class);
//        String logAnnoNameValue = null;
//        if(annotation!=null){
//            logAnnoNameValue = annotation.name();
//        }
//
//        String username = "admin";
//        log.info("LogAspect:   "+"username:"+username+",userAction:"+methodName+":"+logAnnoNameValue+",createTime:"+new Date().toString());
//        Object proceed =null;
//        try {
//            proceed = joinPoint.proceed();
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return proceed;


//    }

}

