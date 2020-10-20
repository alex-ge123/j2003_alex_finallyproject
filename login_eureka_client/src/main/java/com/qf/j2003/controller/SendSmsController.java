package com.qf.j2003.controller;

import com.qf.j2003.service.impl.SendSmsService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
  * Description TODO
  * @date 2020/10/12 21:18
  */
@RestController
//@CrossOrigin
public class SendSmsController {
    @Autowired
    private SendSmsService sendSmsService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @GetMapping("/send")
    public ActionResult sendSms(String tel){
          Map<String, String> map = new HashMap<>();
          String code = UUID.randomUUID().toString().substring(0,6);
          map.put("code",code);
            Boolean isSend = sendSmsService.sendSms(tel, map);
            if (isSend){
                redisTemplate.opsForValue().set(tel,code,5, TimeUnit.MINUTES);
                return new ActionResult(200,"验证码发送成功",null);
            }
            return new ActionResult(201,"验证码发送失败",null);
    }
}
