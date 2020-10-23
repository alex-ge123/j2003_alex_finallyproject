package com.qianfeng.j2003.controller;

import com.qianfeng.j2003.annotation.LogAnno;
import com.qianfeng.j2003.pojo.Teacher;
import com.qianfeng.j2003.service.CourseService;
import com.qianfeng.j2003.service.SubjectService;
import com.qianfeng.j2003.service.TeacherService;
import com.qianfeng.j2003.vo.CourseVo;
import com.qianfeng.j2003.vo.SubjectVo;
import com.qianfeng.j2003.vo.TeaSubCouVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/15.
 */
@RestController
//@CrossOrigin
public class SubjectController {
    @Autowired(required = false)
    private CourseService courseService;
    @Autowired(required = false)
    private  SubjectService subjectService;
    @Autowired(required = false)
    private TeacherService teacherService;
    @RequestMapping(value = "courseNotStart", method = RequestMethod.GET)
    @LogAnno(name = "查找某项课程的详细信息")
    public ResponseEntity findCourseBySubId(@RequestParam("sub_id") int sub_id, @RequestParam("t_id") int t_id){
        List<CourseVo> courseVos = courseService.findCoursesBySubId(sub_id);
        SubjectVo subjectVo = subjectService.findById(sub_id);
        Teacher teacher = teacherService.findTeacherById(t_id);
//        for (CourseVo c:courseVos
//             ) {
//            System.out.println("courseVos:  "+c);
//        }
//        System.out.println("subjectVo:      "+subjectVo);
//        System.out.println("teacher:        "+teacher);
        TeaSubCouVo teaSubCouVo = new TeaSubCouVo();
        teaSubCouVo.setTeacher(teacher);
        teaSubCouVo.setCourseVos(courseVos);
        teaSubCouVo.setSubjectVo(subjectVo);
//        System.out.println(teaSubCouVo);
        return new ResponseEntity(teaSubCouVo, HttpStatus.OK);
    }
}
