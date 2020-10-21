package com.qf.j2003.service.impl;

import com.qf.j2003.mapper.StudentMapper;
import com.qf.j2003.po.Student;
import com.qf.j2003.service.StudentService;
import com.qf.j2003.util.JsonUtil;
import com.qf.j2003.util.RedisUtil;
import com.qf.j2003.vo.ActionResult;
import com.qf.j2003.vo.StudentVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by henry on 2020/10/15.
 */
@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    //注入自定义的redis工具
    @Autowired
  private RedisUtil redisUtil;
    @Autowired(required = false)
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAllStudent() {
       //先查redis,获取redis中存储的redis字符串
        String json1 = redisUtil.hget("students","0");
        if(json1!=null){
            log.info("get students from redis");
            List<Student> students = JsonUtil.jsonToList(json1,Student.class);
            return students;
        }else {
            List<Student> allStudent = studentMapper.selectAllStudent();
            log.info("get students from db");
            try {
                String json = JsonUtil.objectToJson(allStudent);
                //放入redis中
                redisUtil.hset("students","0",json);
                return allStudent;
            } catch (Exception e) {
                return null;
            }
        }
    }


    //学生信息条件查询
    @Override
    public List<Student> findSomeStudent(StudentVo studentVo) {
        try {
            List<Student> students = studentMapper.selectSomeStudent(studentVo);
            return students;
        }catch (Exception e){
            return null;
        }

    }

}
