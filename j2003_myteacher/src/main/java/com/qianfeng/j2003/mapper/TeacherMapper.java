package com.qianfeng.j2003.mapper;

import com.qianfeng.j2003.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ZAM-PC on 2020/10/14.
 */
public interface TeacherMapper {
    public Teacher findTeacherById(@Param("id") int id);
}
