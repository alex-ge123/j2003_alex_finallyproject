package com.qf.j2003.mapper;

import com.qf.j2003.pojo.CourseManagement;

import java.util.List;

public interface CourseManagementMapper {
    List<CourseManagement> findAll(int deleteStatus);
}
