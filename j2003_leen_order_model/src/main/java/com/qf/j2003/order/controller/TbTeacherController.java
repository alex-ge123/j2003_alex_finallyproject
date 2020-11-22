package com.qf.j2003.order.controller;


import com.qf.j2003.order.pojo.TbTeacher;
import com.qf.j2003.order.service.TbTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping(value = "/order/tb-teacher",method = RequestMethod.GET)
@CrossOrigin
public class TbTeacherController {
    @Autowired
    private TbTeacherService service ;

    @RequestMapping(value = "/income",method = RequestMethod.GET)
    public List<TbTeacher> incomeInfo(){
        return service.list(null);
    }
}

