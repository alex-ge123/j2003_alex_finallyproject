package com.qianfeng.j2003.aop;

import com.qianfeng.j2003.annotation.LogAnno;
import com.qianfeng.j2003.pojo.SysLog;
import com.qianfeng.j2003.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Aspect   //标识为切面
@Component  //标识此类为spring管理
@Slf4j   //标识日志
public class MyLog {

    @Pointcut("@annotation(com.qianfeng.j2003.annotation.LogAnno)")
    public void pointCut(){}
    @Around("pointCut()")
    public Object aroud(ProceedingJoinPoint joinPoint){
    MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
    String name = methodSignature.getName();
    System.out.println(name);
    LogAnno logAnno = methodSignature.getMethod().getAnnotation(LogAnno.class);
    String logAnnoNameValue =null;
    if(logAnno!=null){//注解存在
        logAnnoNameValue = logAnno.name();//获取指定注解中的name属性值
    }
    String username = "admin";
//    log.info("username:"+username+",userAction:"+name+":"+logAnnoNameValue+",createTime:"+new Date().toString());

    SysLog sysLog = new SysLog();
    sysLog.setUserName(username);
    sysLog.setUserAction(name+":"+logAnnoNameValue);
    sysLog.setCreateTime(new Date());

    Object proceed =null;
    try {
    //        执行切点对象方法
        proceed = joinPoint.proceed();
    } catch (Throwable throwable) {
        throwable.printStackTrace();
    }
    return proceed;
}

}
