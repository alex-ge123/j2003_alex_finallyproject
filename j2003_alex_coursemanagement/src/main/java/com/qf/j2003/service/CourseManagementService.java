package com.qf.j2003.service;

import com.qf.j2003.pojo.CourseManagement;


import java.util.List;


public interface CourseManagementService {
    List<CourseManagement> findAll(int DELETESTATUS);
}
