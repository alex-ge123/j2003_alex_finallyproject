package com.qf.j2003.mapper;

import com.qf.j2003.pojo.Subject;

import java.util.List;

public interface SubjectMapper {

    public List<Subject> findAllSubject( int deleteStatus);

}
