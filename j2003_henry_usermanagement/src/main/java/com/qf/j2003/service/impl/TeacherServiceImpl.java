package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.TeacherMapper;
import com.qf.j2003.po.Teacher;
import com.qf.j2003.service.TeacherService;
import com.qf.j2003.vo.TeacherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by henry on 2020/10/20.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired(required = false)
    private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> findAllTeacher() {
        try{
            List<Teacher> teachers = teacherMapper.selectAllTeacher();
            return teachers;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        boolean b;
       try {
           teacherMapper.insertTeacher(teacher);
           b=true;
           return b;
       }catch (Exception e){
           System.out.println("fail...");
           b=false;
           return b;
       }
    }

    @Override
    public List<Teacher> findSomeTeacher(TeacherVo teacherVo) {
        try {
            List<Teacher> teachers = teacherMapper.selectSomeTeacher(teacherVo);
            return teachers;
        }catch (Exception e){
            return null;
        }
    }
}
