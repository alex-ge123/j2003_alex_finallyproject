package com.qf.j2003.controller;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.discovery.converters.Auto;
import com.qf.j2003.po.Teacher;
import com.qf.j2003.po.UserInfo;
import com.qf.j2003.service.AuthenService;
import com.qf.j2003.service.StudentService;
import com.qf.j2003.service.TeacherService;
import com.qf.j2003.util.ActionResult;
import com.qf.j2003.po.Student;
import com.qf.j2003.util.AppConstant;
import com.qf.j2003.util.CookieUtil;
import com.qf.j2003.utils.EncryptUtil;
import com.sun.deploy.association.utility.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
//@CrossOrigin
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private AuthenService authenService;

    //用户注册
    @PostMapping("userInfo")
    public ActionResult dealReg(@RequestBody Student student) {
        String sms = redisTemplate.opsForValue().get(student.getTel());
        if (StringUtils.isEmpty(sms)) {
            return new ActionResult(201, "验证码已过期，请重新发送", student);
        } else if (sms.equals(student.getSms())) {
            Student info = studentService.findStuByTel(student.getTel());
            if (info == null) {
                String password = EncryptUtil.AESencode(student.getTel(), student.getPassword());
                student.setPassword(password);
                System.out.println("加密后密码：" + student.getPassword());
                studentService.addStu(student);
                return new ActionResult(200, "注册成功", student);
            }
            return new ActionResult(201, "该手机号已经被注册", null);
        } else {
            return new ActionResult(201, "验证码错误", null);
        }
    }
    //用户登录
    @PostMapping(value = "login")
    public ActionResult dealLogin(@RequestBody UserInfo userInfo, HttpServletRequest request,
                                  HttpServletResponse response) throws IOException {
        Student student = null;
        Teacher teacher = null;
        //获取原请求路径
       // String oldRequestUrl = CookieUtil.getCookie(request, "oldRequestUrl");
        //String uuid = CookieUtil.getCookie(request,"uuid");
        String uuid = request.getSession().getId();
        System.out.println("登录处理"+uuid);
        //创建令牌
        String token = authenService.createToken(uuid);
        if (userInfo.getRadio() == 1) {
            student = studentService.findStuByTel(userInfo.getTel());
        } else if (userInfo.getRadio() == 2) {
            teacher = teacherService.findTeaByTel(userInfo.getTel());
        }
        if (student != null) {
            if (EncryptUtil.AESDecode(student.getTel(), student.getPassword()).equals(userInfo.getPassword())) {
                System.out.println("学生登录");
                redisTemplate.opsForValue().set(token, userInfo.getTel());
                CookieUtil.setCookie(response,"token",token,60000);
                System.out.println("返回数据");
                return new ActionResult(200, "登录成功", userInfo.getRadio());
            }
        } else if (teacher != null) {
            if (EncryptUtil.AESDecode(teacher.getTel(), teacher.getPassword()).equals(userInfo.getPassword())) {
                redisTemplate.opsForValue().set(token, userInfo.getTel());
                return new ActionResult(200, "登录成功", userInfo.getRadio());
            }
        }
        return new ActionResult(201, "用户不存在或密码错误", null);
    }
    /**
      * Description: 令牌有效性检查
      * @param token 令牌
      * @return 校验结果
      */
    @PostMapping("checkToken")
    public Boolean checkToken(@RequestParam("token") String token,HttpServletResponse response){
        System.out.println(token);
        String tel = redisTemplate.opsForValue().get(token);
        System.out.println("令牌验证"+token);
        if (StringUtils.isEmpty(tel)){
            return false;
        }
        CookieUtil.setCookie(response,"token",token,600);
        return true;
    }
}
