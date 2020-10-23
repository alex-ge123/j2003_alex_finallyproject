package com.qf.j2003.mapper;

import com.qf.j2003.po.Student;
import com.qf.j2003.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * Created by henry on 2020/10/15.
 */
@Mapper
public interface StudentMapper {
    //学生信息全查
    public List<Student> selectAllStudent();
    //学生信息条件查询
    public List<Student> selectSomeStudent(StudentVo studentVo);
}
