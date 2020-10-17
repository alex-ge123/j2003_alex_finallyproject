package com.qf.j2003.mapper;


import com.qf.j2003.pojo.Course;
import com.qf.j2003.pojo.CourseManagement;
import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.pojo.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class J2003AlexCoursemanagementApplicationTests {
    @Autowired(required = false)
    private SubjectMapper subjectMapper;
    @Autowired(required = false)
    private CourseMapper courseMapper;
    @Autowired(required = false)
    private CourseManagementMapper courseManagementMapper;

    @Test
    void contextLoads() {
        CourseVo courseVo = new CourseVo();
        courseVo.setS_id(24);
        courseVo.setSub_id(15);
        courseVo.setT_id(5);
        courseMapper.addCourseVo(courseVo);


    }

}
