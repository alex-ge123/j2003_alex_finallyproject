package com.qf.j2003.order.controller;


import com.netflix.discovery.converters.Auto;
import com.qf.j2003.order.pojo.TbOrder;
import com.qf.j2003.order.service.impl.TbOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-10-13
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/order/tb-order",method = RequestMethod.GET)
public class TbOrderController {
    @Autowired
    TbOrderServiceImpl service ;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<TbOrder> findAll(){
        return service.list(null);
    }

}

