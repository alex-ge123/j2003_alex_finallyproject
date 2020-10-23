package com.qianfeng.j2003.service;

import com.qianfeng.j2003.vo.CourseVo;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
public interface CourseService {
    public List<CourseVo> findCoursesBySubId(int id);
}
