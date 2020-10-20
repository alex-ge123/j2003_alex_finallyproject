package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.TeacherMapper;
import com.qf.j2003.po.Teacher;
import com.qf.j2003.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * Description
  * @date 2020/10/12 15:04
  */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired(required = false)
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findTeaByTel(String tel) {
        return teacherMapper.selectTeaByTel(tel);
    }
}
