package com.qf.j2003.order.controller;


import com.qf.j2003.order.pojo.TbTeacher;
import com.qf.j2003.order.service.TbTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/order/tb-teacher")
@CrossOrigin
public class TbTeacherController {
    @Autowired
    private TbTeacherService service ;

    @GetMapping("/income")
    public List<TbTeacher> incomeInfo(){
        return service.list(null);
    }
}

