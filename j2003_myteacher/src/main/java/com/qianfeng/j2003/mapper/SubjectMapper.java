package com.qianfeng.j2003.mapper;

import com.qianfeng.j2003.vo.CourseVo;
import com.qianfeng.j2003.vo.SubjectVo;

import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/15.
 */
public interface SubjectMapper {
    public List<SubjectVo> findByTeacherId(int id);
    public SubjectVo findById(int id);
}
