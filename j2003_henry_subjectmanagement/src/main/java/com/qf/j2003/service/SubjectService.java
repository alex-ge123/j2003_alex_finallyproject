package com.qf.j2003.service;

import com.qf.j2003.po.Subject;

import java.util.List;

/**
 * Created by henry on 2020/10/16.
 */
public interface SubjectService {
    //根据类型查询课程信息
    public List<Subject> findSubjectByType(String subType);
}
