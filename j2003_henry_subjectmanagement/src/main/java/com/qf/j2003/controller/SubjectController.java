package com.qf.j2003.controller;

import com.qf.j2003.po.Subject;
import com.qf.j2003.service.SubjectService;
import com.qf.j2003.vo.ActionResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by henry on 2020/10/16.
 */
@RestController
@CrossOrigin
public class SubjectController {
    @Autowired(required = false)
    private SubjectService subjectService;

    @RequestMapping(value = "subjectlist",method = RequestMethod.GET)
    public ActionResult querySubjectByType(@RequestParam(value ="subType")String subType){
        System.out.println("请求来了~"+subType);
        List<Subject> subjects = subjectService.findSubjectByType(subType);
       for(Subject s:subjects){
           System.out.println(s);
       }
        ActionResult result = new ActionResult();
        result.setData(subjects);
        result.setMsg("success");
        result.setStatusCode(200);
        return result;
    }
}
