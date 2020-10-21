package com.qianfeng.j2003.service.impl;



import com.alibaba.fastjson.JSON;
import com.qianfeng.j2003.mapper.SubjectMapper;
import com.qianfeng.j2003.service.SubjectService;
import com.qianfeng.j2003.util.SingleTonRedisUtils;
import com.qianfeng.j2003.vo.CourseVo;
import com.qianfeng.j2003.vo.SubjectVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;

/**
 * Created by ZAM-PC on 2020/10/15.
 */
@Service
@Slf4j
public class SubjectServiceImpl implements SubjectService {
    @Autowired(required = false)
    private SubjectMapper subjectMapper;
//    @Autowired(required = false)
//    private SingleTonRedisUtils singleTonRedisUtils;
    @Override
    public List<SubjectVo> findByTeacherId(int id) {
//        //先查询redis
//        String subjectVos1 = singleTonRedisUtils.hget("subjectVos", "0");
//        if(subjectVos1!=null){
//            log.info("get from redis");
//            List<SubjectVo> subjectVos = JSON.parseArray(subjectVos1, SubjectVo.class);
//            return subjectVos;
//        }
//        log.info("get from DB");
        List<SubjectVo> subjectVos = subjectMapper.findByTeacherId(id);
//        try{
//            String s = JSON.toJSONString(subjectVos);
//            singleTonRedisUtils.hset("subjectVos","0",s);
//            log.info("set to redis");
//        }catch (Exception e){
//            log.info(e.getMessage());
//        }
        return subjectVos;
    }

    @Override
    public SubjectVo findById(int id) {
        SubjectVo subjectVo = subjectMapper.findById(id);
        return subjectVo;
    }


}
