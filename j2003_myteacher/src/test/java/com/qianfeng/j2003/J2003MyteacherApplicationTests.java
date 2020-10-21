package com.qianfeng.j2003;
import com.qianfeng.j2003.controller.TeacherController;
import com.qianfeng.j2003.mapper.CourseMapper;
import com.qianfeng.j2003.mapper.SubjectMapper;
import com.qianfeng.j2003.mapper.TeacherMapper;
import com.qianfeng.j2003.pojo.Teacher;
import com.qianfeng.j2003.service.SubjectService;
import com.qianfeng.j2003.service.TeacherService;
import com.qianfeng.j2003.vo.CourseVo;
import com.qianfeng.j2003.vo.SubjectVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class J2003MyteacherApplicationTests {
	@Autowired(required = false)
	private TeacherMapper teacherMapper;
	@Autowired(required = false)
	private TeacherService teacherService;
	@Autowired(required = false)
	private SubjectService subjectService;
	@Autowired(required = false)
	private SubjectMapper subjectMapper;
	@Autowired(required = false)
	private CourseMapper courseMapper;
	@Test
	public void contextLoads() {
//		Teacher teacher = teacherMapper.findTeacherById(1);
		Teacher teacher = teacherService.findTeacherById(1);
		System.out.println(teacher);
		log.info(teacher.toString());
	}

	@Test
	public void testSub() {
		List<SubjectVo> subjectVos = subjectService.findByTeacherId(1);
		for (SubjectVo s: subjectVos
			 ) {
			log.info(s.toString());
		}
	}

	@Test
	public void testSub1() {
		SubjectVo subjectVo = subjectService.findById(9);
			log.info(subjectVo.toString());

	}
	@Test
	public void testSub2() {
		List<CourseVo> coursesBySubId = courseMapper.findCoursesBySubId(9);
		for (CourseVo courseVo:coursesBySubId
			 ) {

			log.info(courseVo.toString());
		}

	}
}
