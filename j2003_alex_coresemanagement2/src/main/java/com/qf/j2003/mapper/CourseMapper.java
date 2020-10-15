package com.qf.j2003.mapper;

import com.qf.j2003.pojo.Course;

import java.util.List;

public interface CourseMapper{

    public List<Course> findAllCourse(int deleteStatus);


}
