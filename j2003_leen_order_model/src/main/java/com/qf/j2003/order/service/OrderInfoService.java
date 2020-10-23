package com.qf.j2003.order.service;

import com.qf.j2003.order.pojo.OrderInfo;
import com.qf.j2003.order.pojo.QueryWrapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface OrderInfoService
{
    List<OrderInfo> getOrderInfo() ;
    List<Map<String, Object>> getOrderInfoFuzzy(int pageNo, int pageSize, QueryWrapper queryWrapper) throws IOException;
}
