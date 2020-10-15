package com.qf.j2003;

import com.qf.j2003.mapper.CourseManagementMapper;
import com.qf.j2003.mapper.CourseMapper;
import com.qf.j2003.mapper.SubjectMapper;
import com.qf.j2003.pojo.Course;
import com.qf.j2003.pojo.CourseManagement;
import com.qf.j2003.pojo.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    List<Subject> allSubject = subjectMapper.findAllSubject(1);
    for (Subject subject:allSubject){

      System.out.println(subject);
    }


  }
    @Test
    void contextLoads2() {
        List<Course> allCourse = courseMapper.findAllCourse(1);
        for (Course c :allCourse ) {
      System.out.println(c);
        }
    }
    @Test
    void contextLoads3() {
        List<CourseManagement> all = courseManagementMapper.findAll(1);
        for (CourseManagement c :all ) {
      System.out.println(c);
        }
    }
}
