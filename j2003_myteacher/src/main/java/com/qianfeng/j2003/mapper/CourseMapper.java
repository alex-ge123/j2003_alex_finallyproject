package com.qianfeng.j2003.mapper;

import com.qianfeng.j2003.vo.CourseVo;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
public interface CourseMapper {
    public List<CourseVo> findCoursesBySubId(int id);
}
