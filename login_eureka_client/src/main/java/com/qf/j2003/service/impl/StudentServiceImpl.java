package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.StudentMapper;
import com.qf.j2003.service.StudentService;
import com.qf.j2003.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
  * Description
  * @date 2020/10/12 15:04
  */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    private StudentMapper studentMapper;
    @Override
    public Student findStuByTel(String tel) {
        Student student = studentMapper.selectStuByTel(tel);
        return student;
    }

    @Override
    public void addStu(Student student) {
        studentMapper.insertStu(student);
    }
}
