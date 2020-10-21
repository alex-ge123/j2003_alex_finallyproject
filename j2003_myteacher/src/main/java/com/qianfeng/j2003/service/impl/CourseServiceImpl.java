package com.qianfeng.j2003.service.impl;

import com.qianfeng.j2003.mapper.CourseMapper;
import com.qianfeng.j2003.service.CourseService;
import com.qianfeng.j2003.vo.CourseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/19.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired(required = false)
    private CourseMapper courseMapper;
    @Override
    public List<CourseVo> findCoursesBySubId(int id) {
        List<CourseVo> courseVos = courseMapper.findCoursesBySubId(id);
        return courseVos;
    }
}
