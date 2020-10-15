package com.qf.j2003.controller;

import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseManagementController {
@Autowired
    private RemoteRibbonService remoteRibbonService;
@RequestMapping(value = "coursemanagements" ,method = RequestMethod.GET)
public ActionResult findAllCourseManagement(){
    ActionResult allCourseManagement = remoteRibbonService.findAllCourseManagement();
    return allCourseManagement;
}

}
