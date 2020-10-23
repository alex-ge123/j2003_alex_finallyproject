package com.qf.j2003.aop;

import com.qf.j2003.annotation.Log;
import com.qf.j2003.po.Syslog;
import com.qf.j2003.service.SyslogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by henry on 2020/10/19.
 */
//标识本类由spring容器管理
    @Component
    //标识这是一个aop切面编程类
    @Aspect
public class SysLogAop {
    //注入日志操作业务接口
    @Autowired(required = false)
    private SyslogService syslogService;

    //定义一个切点,方法前存在@Log注解的就是切入点
    @Pointcut("@annotation(com.qf.j2003.annotation.Log)")
    public void pointcut(){}

    //定义一个环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object proceed = null;
        Syslog syslog = new Syslog();
        //操作的时间
        syslog.setCreateTime(new Date());
        //用1代表已登录管理员账号
        syslog.setUserID(1);
        //获取切点的方法签名
        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取方法签名上的@Log注解
        Log annotation = signature.getMethod().getAnnotation(Log.class);
        if(annotation!=null){
            String userActionName = annotation.name();
            syslog.setUserAction(userActionName);
        }
        try {
            //将日执写入数据库
            syslogService.insertSyslog(syslog);
            //执行切点对象方法
            proceed = point.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return proceed;
    }
    }
