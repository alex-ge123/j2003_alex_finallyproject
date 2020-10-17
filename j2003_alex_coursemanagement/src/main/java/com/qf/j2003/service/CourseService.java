package com.qf.j2003.service;

import com.qf.j2003.pojo.Course;
import com.qf.j2003.pojo.CourseVo;


import java.util.List;


public interface CourseService {
    public List<Course> findAllCourse( int DELETESTATUS);
    CourseVo addCourseVo(CourseVo courseVo);
}
