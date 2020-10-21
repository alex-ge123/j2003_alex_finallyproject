package com.qf.j2003.mapper;

import com.qf.j2003.po.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.security.PublicKey;
import java.util.List;

/**
 * Created by henry on 2020/10/16.
 */
@Mapper
public interface SubjectMapper {
    //所有课程信息查询
    public List<Subject> selectAllSubejectByType(String subType);

    //根据id查询课程信息详情
    public List<Course>
}
