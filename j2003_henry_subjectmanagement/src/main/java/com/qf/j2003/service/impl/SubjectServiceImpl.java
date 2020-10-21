package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.SubjectMapper;
import com.qf.j2003.po.Subject;
import com.qf.j2003.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by henry on 2020/10/16.
 */
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired(required = false)
    private SubjectMapper subjectMapper;
    @Override
    public List<Subject> findSubjectByType(String subType) {
        try {
            List<Subject> subjects = subjectMapper.selectAllSubejectByType(subType);
            return subjects;
        }catch (Exception e){
            return null;
        }
    }
}
