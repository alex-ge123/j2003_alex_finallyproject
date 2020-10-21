package com.qianfeng.j2003.controller;

import com.qianfeng.j2003.annotation.LogAnno;
import com.qianfeng.j2003.pojo.Teacher;
import com.qianfeng.j2003.service.SubjectService;
import com.qianfeng.j2003.service.SysLogService;
import com.qianfeng.j2003.service.TeacherService;
import com.qianfeng.j2003.vo.SubjectVo;
import com.qianfeng.j2003.vo.TeaSubVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/14.
 */
@RestController
//@CrossOrigin
public class TeacherController {
    @Autowired(required = false)
    private TeacherService teacherService;
    @Autowired(required = false)
    private SubjectService subjectService;
    @Autowired(required = false)
    private SysLogService sysLogService;
    @RequestMapping(value = "/teacher",method = RequestMethod.GET)
    @LogAnno(name = "查询老师的所有课程列表")
    public ResponseEntity findTeacherById(@RequestParam("id") int t_id){
        Teacher teacher = teacherService.findTeacherById(t_id);
        List<SubjectVo> subjectVos = subjectService.findByTeacherId(t_id);
        TeaSubVo teaSubVo = new TeaSubVo();
        teaSubVo.setSubjectVos(subjectVos);
        teaSubVo.setTeacher(teacher);
//        System.out.println(teacher);
//        for (SubjectVo s:subjectVos
//             ) {
//            System.out.println(s);
//        }
//        System.out.println(teaSubVo);
        return new ResponseEntity(teaSubVo,HttpStatus.OK);
    }
}
