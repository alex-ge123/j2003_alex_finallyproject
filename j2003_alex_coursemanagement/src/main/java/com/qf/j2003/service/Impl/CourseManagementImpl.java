package com.qf.j2003.service.Impl;

import com.qf.j2003.mapper.CourseManagementMapper;
import com.qf.j2003.pojo.CourseManagement;
import com.qf.j2003.service.CourseManagementService;
import com.qf.j2003.util.JsonUtils;
import com.qf.j2003.util.SingleTonRedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.JstlUtils;

import java.util.List;
@Service
@Slf4j
public class CourseManagementImpl implements CourseManagementService {
    @Autowired(required = false)
    private CourseManagementMapper courseManagementMapper;
    @Autowired(required = false)
    private SingleTonRedisUtil redisUtil;
    @Override
    public List<CourseManagement> findAll(int DELETESTATUS) {

    //      先查redis
    //       获取redis中存出的json字符串
        String json1 = redisUtil.hget("coursemanages", "0");
        if(json1!=null){
        log.info("查询redis获取");
            List<CourseManagement> courseManagements = JsonUtils.jsonToList(json1, CourseManagement.class);
            return courseManagements;
        }else{
            List<CourseManagement> all = courseManagementMapper.findAll(DELETESTATUS);
            log.info("查询数据库获取 ");
            try {
//        将查询的集合转为json字符串
                String toJson = JsonUtils.objectToJson(all);
//        放入redis中
                redisUtil.hset("coursemanages", "0", toJson);
                redisUtil.expire("coursemanages",3600);
                log.info("set data to redis");
            }catch (Exception ex){
                    log.info("放入redis异常");
            }
            return all;
        }


        }


}
