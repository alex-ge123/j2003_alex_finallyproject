package com.qf.j2003.mapper;

import com.qf.j2003.po.Teacher;

public interface TeacherMapper {
    /**
      * Description: 根据手机号查找用户
      * @param tel 手机号码
      * @return userInfo 用户实体
      */
    Teacher selectTeaByTel(String tel);
}
