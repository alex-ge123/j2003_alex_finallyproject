package com.qf.j2003.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Created by jeffrey on 2020/9/24.
 */
@Service
@Slf4j
public class RemoteRibbonServiceImpl implements RemoteRibbonService {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 通过ribbon远程访问
     *
     * @return
     */
    // 服务降级  当远程调用出现异常时，退一步执行fetchMsgErro
    @HystrixCommand(fallbackMethod="fetchMsgError")
    @Override
    public ActionResult findAllCourseManagement() {
        String url = "http://alex-prodcuer-coursemanagement/coursemanagements";
        ActionResult forObject = restTemplate.getForObject(url, ActionResult.class);
       if(forObject!=null){
           return forObject;
       }
        return null;
    }
    // 服务降级  当远程调用出现异常时，退一步执行fetchMsgErro
    @Override
    @HystrixCommand(fallbackMethod="addCourseError")
    public ActionResult addCourse(CourseVo courseVo) {
        String url ="http://alex-prodcuer-coursemanagement/course";
        ActionResult actionResult = restTemplate.postForObject(url, courseVo, ActionResult.class);
        return actionResult;
    }
    //执行降级服务
    public  ActionResult fetchMsgError(){
        log.info("执行降级服务");
        return new ActionResult(500," 全查失败",null);
    }
    //执行降级服务
    public  ActionResult addCourseError(CourseVo courseVo){
        log.info("执行降级服务");
        return new ActionResult(500," 增加失败",null);
    }
}
