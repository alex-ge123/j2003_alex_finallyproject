package com.qf.j2003.service;

import com.qf.j2003.pojo.Course;

import java.util.List;


public interface CourseService {
    public List<Course> findAllCourse(int DELETESTATUS);
}
