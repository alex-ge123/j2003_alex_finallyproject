package com.qf.j2003;

import com.qf.j2003.mapper.SubjectMapper;
import com.qf.j2003.pojo.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class J2003AlexCoursemanagementApplicationTests {
  @Autowired(required = false)
 private SubjectMapper subjectMapper;
  @Test
  void contextLoads() {
    List<Subject> allSubject = subjectMapper.findAllSubject(1);
    for (Subject subject:allSubject){

      System.out.println(subject);
    }


  }


}
