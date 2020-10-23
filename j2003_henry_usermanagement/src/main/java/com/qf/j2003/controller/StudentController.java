package com.qf.j2003.controller;

import com.qf.j2003.annotation.Log;
import com.qf.j2003.po.Student;
import com.qf.j2003.service.StudentService;
import com.qf.j2003.vo.ActionResult;
import com.qf.j2003.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by henry on 2020/10/15.
 */
@RestController
@CrossOrigin
public class StudentController {
    @Autowired(required = false)
    private StudentService studentService;

    @RequestMapping(value = "studentlist",method = RequestMethod.GET)
    @Log(name="学生信息全查")
    public ActionResult queryAllStudent(){
        System.out.println("请求来啦....");
        List<Student> allStudent = studentService.findAllStudent();

//        for (Student s:allStudent){
//            System.out.println(s);
//        }
        ActionResult actionResult = new ActionResult(200, "success", allStudent);
        return  actionResult;
    }

    @RequestMapping(value = "findSomeStudent",method = RequestMethod.POST)
    public ActionResult querySomeStudent(@RequestBody StudentVo studentVo){
        System.out.println("查询请求来了..."+studentVo);
        List<Student> someStudent = studentService.findSomeStudent(studentVo);
        ActionResult actionResult = new ActionResult(200, "success", someStudent);
        return actionResult;
    }
}
