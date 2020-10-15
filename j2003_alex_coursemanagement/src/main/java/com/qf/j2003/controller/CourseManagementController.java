package com.qf.j2003.controller;

import com.qf.j2003.pojo.CourseManagement;
import com.qf.j2003.service.CourseManagementService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CourseManagementController {
    private  int DELETESTATUS=1;
    @Autowired(required = false)
    private CourseManagementService courseManagementService;
    @RequestMapping(value = "/coursemanagements" ,method = RequestMethod.GET)
    public ActionResult findAll(){
        List<CourseManagement> all = courseManagementService.findAll(DELETESTATUS);
        if(all!=null){
        return  new ActionResult(200,"查询成功",all);
        }
        return null;
    }
}
