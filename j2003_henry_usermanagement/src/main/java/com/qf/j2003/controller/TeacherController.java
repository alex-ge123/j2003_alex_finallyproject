package com.qf.j2003.controller;

import com.qf.j2003.po.Teacher;
import com.qf.j2003.service.TeacherService;
import com.qf.j2003.vo.ActionResult;
import com.qf.j2003.vo.TeacherVo;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by henry on 2020/10/20.
 */
@CrossOrigin
@RestController
public class TeacherController {
    @Autowired(required = false)
    private TeacherService teacherService;
//老师信息全查
    @RequestMapping(value = "teacherlist",method = RequestMethod.GET)
    public ActionResult queryAllTeachers(){
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        for(Teacher t:allTeacher){
            System.out.println(t);
        }
        ActionResult actionResult = new ActionResult();
        actionResult.setStatusCode(200);
        actionResult.setMsg("success");
        actionResult.setData(allTeacher);
        return actionResult;
    }
//老师信息添加
    @RequestMapping(value = "teacheradd",method = RequestMethod.POST)
    public ActionResult addTeacher(@RequestBody Teacher teacher){
        System.out.println("请求来了..."+teacher+"xxxxxxx");
        boolean b = teacherService.addTeacher(teacher);
        System.out.println(b+"sadasdadsasd");
        if(b){
            ActionResult actionResult = new ActionResult();
            actionResult.setStatusCode(200);
            actionResult.setMsg("sueecess");
            actionResult.setData(b);
            return actionResult;
        }else {
            ActionResult actionResult = new ActionResult();
            actionResult.setStatusCode(400);
            actionResult.setMsg("fail");
            actionResult.setData(null);
            return actionResult;
        }

    }
    //老师信息条件查询
    @RequestMapping(value = "findSomeTeacher",method = RequestMethod.POST)
    public ActionResult querySomeStudent(@RequestBody TeacherVo teacherVo){
        System.out.println("老师查询请求来了..."+teacherVo);
        TeacherVo teacherVo1 = new TeacherVo();
        if(teacherVo.getTstatus().equals("在职")){
            teacherVo1.setTstatus("1");
        }else {
            teacherVo.setTstatus("0");
        }
        teacherVo1.setUsername(teacherVo.getUsername());
        teacherVo1.setStartTime(teacherVo.getStartTime());
        teacherVo1.setEndTime(teacherVo.getEndTime());
        System.out.println("新建老师对象t1"+teacherVo1);
        List<Teacher> someTeacher = teacherService.findSomeTeacher(teacherVo1);
        for(Teacher teacher:someTeacher){
            System.out.println(teacher);
        }
        ActionResult actionResult = new ActionResult(200, "success", someTeacher);
        return actionResult;
    }
}
