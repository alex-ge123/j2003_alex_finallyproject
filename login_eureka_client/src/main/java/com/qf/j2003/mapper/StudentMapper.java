package com.qf.j2003.mapper;

import com.qf.j2003.po.Student;

public interface StudentMapper {
    /**
      * Description: 根据手机号查找用户
      * @param tel 手机号码
      * @return userInfo 用户实体
      */
    Student selectStuByTel(String tel);
    /**
     * Description: 添加用户
     * @param student 添加用户信息
     */
    void insertStu(Student student);
}
