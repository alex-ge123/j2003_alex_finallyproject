package com.qf.j2003.order.controller;

import com.alibaba.fastjson.JSON;
import com.qf.j2003.order.pojo.OrderInfo;
import com.qf.j2003.order.pojo.QueryWrapper;
import com.qf.j2003.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderInfoController {

    @Autowired
    private OrderInfoService service ;

    @GetMapping("/order/orderInfo")
    public List<OrderInfo> getOrderInfo(){
        return service.getOrderInfo();
    }

    @GetMapping("/order/search/order")
    public String getOrderInfo(QueryWrapper queryWrapper) throws IOException {
        System.out.println(queryWrapper);
        List<Map<String, Object>> orderInfoFuzzy = service.getOrderInfoFuzzy(1, 5, queryWrapper);
        ArrayList<String> strings = new ArrayList<String>();
        for (Map<String, Object> stringObjectMap : orderInfoFuzzy) {
            strings.add(JSON.toJSONString(stringObjectMap));
        }
        return JSON.toJSONString(strings);
    }

}
