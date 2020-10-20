package com.qf.j2003.service;


import com.qf.j2003.pojo.CourseVo;
import com.qf.j2003.util.ActionResult;

/**
 * Created by jeffrey on 2020/9/24.
 */
public interface RemoteRibbonService {

   public ActionResult findAllCourseManagement();
   public ActionResult addCourse(CourseVo courseVo);


}
