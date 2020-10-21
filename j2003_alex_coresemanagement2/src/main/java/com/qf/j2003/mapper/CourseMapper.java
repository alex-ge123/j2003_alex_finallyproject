package com.qf.j2003.mapper;


import com.qf.j2003.pojo.Course;
import com.qf.j2003.pojo.CourseVo;

import java.util.List;

public interface CourseMapper{

     List<Course> findAllCourse(int deleteStatus);
   void addCourseVo(CourseVo courseVo);
}
