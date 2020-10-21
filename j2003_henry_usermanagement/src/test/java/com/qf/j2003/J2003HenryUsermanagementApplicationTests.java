package com.qf.j2003;
import com.qf.j2003.mapper.StudentMapper;
import com.qf.j2003.mapper.TeacherMapper;
import com.qf.j2003.po.Student;
import com.qf.j2003.po.Teacher;
import com.qf.j2003.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class J2003HenryUsermanagementApplicationTests {

	@Autowired(required = false)
	private StudentMapper studentMapper;
	@Autowired(required = false)
	private StudentService studentService;
	@Autowired(required = false)
	private TeacherMapper teacherMapper;

	@Test
	public void contextLoads() {
        List<Student> students = studentMapper.selectAllStudent();
        for(Student s:students){
            System.out.println(s);
        }
    }

    @Test
	public void teachertest(){
        List<Teacher> teachers = teacherMapper.selectAllTeacher();
        for(Teacher t:teachers){
            System.out.println(t);
        }
    }

}
