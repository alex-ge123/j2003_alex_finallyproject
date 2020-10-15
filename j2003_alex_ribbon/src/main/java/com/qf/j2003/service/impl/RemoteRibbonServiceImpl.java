package com.qf.j2003.service.impl;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * Created by jeffrey on 2020/9/24.
 */
@Service
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
    public  ActionResult fetchMsgError(){
        System.out.println("执行降级服务");

        return new ActionResult(403," 托底数据",null);
    }
}
