package com.qianfeng.j2003.service.impl;

import com.qianfeng.j2003.mapper.TeacherMapper;
import com.qianfeng.j2003.pojo.Teacher;
import com.qianfeng.j2003.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZAM-PC on 2020/10/14.
 */
@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired(required = false)
    private TeacherMapper teacherMapper;
    public Teacher findTeacherById(int id){
        Teacher teacher = null;
        try{
            teacher = teacherMapper.findTeacherById(id);
        }catch (Exception e){

        }
        return  teacher;
    }

}
