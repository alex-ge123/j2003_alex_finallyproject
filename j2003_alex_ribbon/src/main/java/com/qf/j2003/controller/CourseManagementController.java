package com.qf.j2003.controller;

import com.qf.j2003.pojo.AddCourseAndTeacher;
import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@Slf4j
public class CourseManagementController {
@Autowired(required = false)
    private RemoteRibbonService remoteRibbonService;
@RequestMapping(value = "coursemanagements" ,method = RequestMethod.GET)
public ActionResult findAllCourseManagement(){
    ActionResult allCourseManagement = remoteRibbonService.findAllCourseManagement();
    return allCourseManagement;
}
/*添加课程*/
@RequestMapping(value = "/course",method = RequestMethod.POST)
public ActionResult addCourseVo(@RequestBody AddCourseAndTeacher addCourseAndTeacher){
    System.out.println("添加课程");
    System.out.println(addCourseAndTeacher.toString());
    log.info(addCourseAndTeacher.toString());

    CourseVo courseVo = new CourseVo();
    courseVo.setS_name(addCourseAndTeacher.getS_name());
    courseVo.setDeletestatus(addCourseAndTeacher.getDeletestatus());
    courseVo.setT_id(addCourseAndTeacher.getT_id());
    courseVo.setSub_id(addCourseAndTeacher.getSub_id());
    courseVo.setS_id(addCourseAndTeacher.getS_id());
    courseVo.setS_createtime(addCourseAndTeacher.getS_createtime());
    courseVo.setS_yijifenlei(addCourseAndTeacher.getS_yijifenlei());
    courseVo.setS_erjifenlei(addCourseAndTeacher.getS_erjifenlei());
    courseVo.setS_imageurl(addCourseAndTeacher.getS_imageurl());
    courseVo.setS_price(addCourseAndTeacher.getS_price());
    courseVo.setS_type(addCourseAndTeacher.getS_type());
    courseVo.setS_showstatus(addCourseAndTeacher.getS_showstatus());
    courseVo.setS_status(addCourseAndTeacher.getS_status());
    courseVo.setS_updatetime(addCourseAndTeacher.getS_updatetime());
    ActionResult actionResult = remoteRibbonService.addCourse(courseVo);
    System.out.println(actionResult.getData()+"==="+actionResult.getMassage()+"==="+actionResult.getStatusCode());
        return  actionResult;
  }


}
