package com.qf.j2003.controller;

import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
public class CourseManagementController {
@Autowired(required = false)
    private RemoteRibbonService remoteRibbonService;
@RequestMapping(value = "coursemanagements" ,method = RequestMethod.GET)
public ActionResult findAllCourseManagement(){
    ActionResult allCourseManagement = remoteRibbonService.findAllCourseManagement();
    return allCourseManagement;
}
@RequestMapping(value = "/course",method = RequestMethod.POST)
public ActionResult addCourseVo(@RequestBody CourseVo courseVo){
    ActionResult actionResult = remoteRibbonService.addCourse(courseVo);
return  actionResult;
}
}
