package com.qf.j2003.controller;

import com.qf.j2003.pojo.Course;
import com.qf.j2003.service.CourseService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CourseController {
    private  int DELETESTATUS=1;
    @Autowired(required = false)
    private CourseService courseService;
    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public ActionResult findAllCourse(){
    System.out.println("开始查询");
        List<Course> allCourse = courseService.findAllCourse(DELETESTATUS);
    System.out.println("查询成功");
        return new ActionResult(200,"查询成功",allCourse);
    }
}
