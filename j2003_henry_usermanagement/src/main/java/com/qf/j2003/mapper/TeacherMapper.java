package com.qf.j2003.mapper;

import com.qf.j2003.po.Teacher;
import com.qf.j2003.vo.TeacherVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by henry on 2020/10/20.
 */
@Mapper
public interface TeacherMapper {
    //老师信息全查
    public List<Teacher> selectAllTeacher();
    //老师信息添加
    public void insertTeacher(Teacher teacher);
    //老师信息模糊查找
    public List<Teacher> selectSomeTeacher(TeacherVo teacherVo);
}
