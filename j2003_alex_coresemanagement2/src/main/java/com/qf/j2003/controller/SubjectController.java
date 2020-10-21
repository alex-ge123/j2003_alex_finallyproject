package com.qf.j2003.controller;

import com.qf.j2003.pojo.Subject;
import com.qf.j2003.service.SubjectService;
import com.qf.j2003.util.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectController {
    private  int DELETESTATUS=1;
    @Autowired (required = false)
    private SubjectService subjectService;
    @RequestMapping(value = "/subjects",method = RequestMethod.GET)
    public ActionResult findSubject(){
        List<Subject> allSubject = subjectService.findAllSubject(DELETESTATUS);
    if (allSubject != null) {
      return new ActionResult(200, "查询成功", allSubject);
            }
    else{
        return new ActionResult(500,"service层查询异常",null);
     }
    }
}
