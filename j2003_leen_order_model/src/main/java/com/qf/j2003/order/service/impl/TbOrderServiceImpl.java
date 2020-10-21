package com.qf.j2003.order.service.impl;

import com.qf.j2003.order.pojo.TbOrder;
import com.qf.j2003.order.mapper.TbOrderMapper;
import com.qf.j2003.order.service.TbOrderService;
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
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements TbOrderService {

    @Autowired
    private TbOrderMapper mapper ;
}
