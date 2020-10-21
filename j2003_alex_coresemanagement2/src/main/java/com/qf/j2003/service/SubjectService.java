package com.qf.j2003.service;

import com.qf.j2003.pojo.Subject;

import java.util.List;

public interface SubjectService {

    public List<Subject> findAllSubject(int deleteStatus);
}
