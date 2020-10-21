package com.qf.j2003.service;

import com.qf.j2003.po.Student;
import com.qf.j2003.vo.StudentVo;

import java.util.List;

/**
 * Created by henry on 2020/10/15.
 */
public interface StudentService {
    public List<Student> findAllStudent();
    public List<Student> findSomeStudent(StudentVo studentVo);

}
