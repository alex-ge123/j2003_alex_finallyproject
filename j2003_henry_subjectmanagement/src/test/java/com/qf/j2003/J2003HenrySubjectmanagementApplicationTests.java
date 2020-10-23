package com.qf.j2003;


import com.qf.j2003.mapper.SubjectMapper;
import com.qf.j2003.po.Subject;
import com.qf.j2003.service.SubjectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public	class J2003HenrySubjectmanagementApplicationTests {
	@Autowired(required = false)
	private SubjectMapper subjectMapper;
    @Autowired(required = false)
    private SubjectService subjectService;
	@Test
	public void contextLoads() {
        List<Subject> list = subjectMapper.selectAllSubejectByType("语文");
        for(Subject l:list){
            System.out.println(l);
        }
    }
    @Test
    public void serviceTest(){
        List<Subject> byType = subjectService.findSubjectByType("语文");
        for (Subject s:byType){
            System.out.println(s);
        }
    }
}
