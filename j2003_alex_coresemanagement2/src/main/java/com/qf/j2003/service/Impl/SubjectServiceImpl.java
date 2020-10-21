package com.qf.j2003.service.Impl;

import com.qf.j2003.mapper.SubjectMapper;
import com.qf.j2003.pojo.Subject;
import com.qf.j2003.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    @Autowired (required = false)
    private SubjectMapper subjectMapper;
    @Override
    public List<Subject> findAllSubject(int deleteStatus) {
        try {
            List<Subject> allSubject = subjectMapper.findAllSubject(deleteStatus);

            return allSubject;
        } catch (Exception e) {
           log.info("查寻mapper层出异常");
        }
        return null;
    }
}
