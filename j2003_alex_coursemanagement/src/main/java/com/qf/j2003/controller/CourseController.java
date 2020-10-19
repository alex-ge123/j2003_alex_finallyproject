package com.qf.j2003.controller;

import com.qf.j2003.pojo.Course;
import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.service.CourseService;
import com.qf.j2003.util.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
public class CourseController {
    private  int DELETESTATUS=1;
    @Autowired(required = false)
    private CourseService courseService;
    //全查课程信息
    @RequestMapping(value = "/courses",method = RequestMethod.GET)
    public ActionResult findAllCourse(){
        log.info("开始查询");

        List<Course> allCourse = courseService.findAllCourse(DELETESTATUS);
        log.info("查询成功");

        return new ActionResult(200,"查询成功",allCourse);
    }
    //添加课程信息
    @RequestMapping(value = "/course",method = RequestMethod.POST)
    public ActionResult addCourese( @RequestBody CourseVo courseVo){
        try {
            CourseVo courseVo1 = courseService.addCourseVo(courseVo);
            return new ActionResult(200,"添加成功",courseVo1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ActionResult(500,"添加异常",null);
    }
}
