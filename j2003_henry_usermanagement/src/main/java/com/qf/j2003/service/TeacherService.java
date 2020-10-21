package com.qf.j2003.service;

import com.qf.j2003.po.Teacher;
import com.qf.j2003.vo.TeacherVo;
import org.bouncycastle.jcajce.provider.symmetric.TEA;

import java.util.List;

/**
 * Created by henry on 2020/10/20.
 */
public interface TeacherService {
    public List<Teacher> findAllTeacher();
    public boolean addTeacher(Teacher teacher);
    public List<Teacher> findSomeTeacher(TeacherVo teacherVo);
}
