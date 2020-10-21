package com.qf.j2003.service;

import com.qf.j2003.po.Student;

public interface StudentService {
    Student findStuByTel(String tel);
    void addStu(Student student);
}
