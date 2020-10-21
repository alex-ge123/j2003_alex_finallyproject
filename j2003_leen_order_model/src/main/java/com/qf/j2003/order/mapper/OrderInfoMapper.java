package com.qf.j2003.order.mapper;

import com.qf.j2003.order.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderInfoMapper{
    List<OrderInfo> findOrderInfo() ;
}
