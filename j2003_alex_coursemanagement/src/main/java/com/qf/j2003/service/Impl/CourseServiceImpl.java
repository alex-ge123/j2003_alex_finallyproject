package com.qf.j2003.service.Impl;

import com.qf.j2003.mapper.CourseMapper;
import com.qf.j2003.pojo.Course;
import com.qf.j2003.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired(required = false)
    private CourseMapper courseMapper;
    @Override
    public List<Course> findAllCourse(int DELETESTATUS) {
        List<Course> allCourse = courseMapper.findAllCourse(DELETESTATUS);
        return allCourse;
    }
}
