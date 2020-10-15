package com.qf.j2003.service.Impl;

import com.qf.j2003.mapper.CourseManagementMapper;
import com.qf.j2003.pojo.CourseManagement;
import com.qf.j2003.service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManagementImpl implements CourseManagementService {
    @Autowired(required = false)
    private CourseManagementMapper courseManagementMapper;

    @Override
    public List<CourseManagement> findAll(int DELETESTATUS) {
        List<CourseManagement> all = courseManagementMapper.findAll(DELETESTATUS);
        return all;
    }
}
