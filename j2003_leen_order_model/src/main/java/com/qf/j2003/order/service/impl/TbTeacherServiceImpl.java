package com.qf.j2003.order.service.impl;

import com.qf.j2003.order.pojo.TbTeacher;
import com.qf.j2003.order.mapper.TbTeacherMapper;
import com.qf.j2003.order.service.TbTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-10-13
 */
@Service
public class TbTeacherServiceImpl extends ServiceImpl<TbTeacherMapper, TbTeacher> implements TbTeacherService {
    @Autowired
    private TbTeacherMapper mapper ;
}
