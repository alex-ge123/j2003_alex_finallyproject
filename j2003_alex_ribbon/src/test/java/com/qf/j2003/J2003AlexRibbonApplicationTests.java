package com.qf.j2003;



import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.service.RemoteRibbonService;
import com.qf.j2003.util.ActionResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class J2003AlexRibbonApplicationTests {
  @Autowired(required = false)
private RemoteRibbonService remoteRibbonService;
  @Test
  void contextLoads() {
    CourseVo courseVo = new CourseVo();
    courseVo.setDeletestatus(1);
    courseVo.setS_name("急急急");
    courseVo.setS_id(24);
    courseVo.setSub_id(15);
    courseVo.setT_id(5);
    ActionResult actionResult = remoteRibbonService.addCourse(courseVo);
    System.out.println(actionResult);
  }
@Test
  void contextLoads2() {
    ActionResult allCourseManagement = remoteRibbonService.findAllCourseManagement();
    System.out.println(allCourseManagement);
  }
}
