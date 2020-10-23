package com.qf.j2003.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.qf.j2003.order.mapper.OrderInfoMapper;
import com.qf.j2003.order.pojo.OrderInfo;
import com.qf.j2003.order.pojo.QueryWrapper;
import com.qf.j2003.order.service.OrderInfoService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper mapper ;

    @Autowired
    private RestHighLevelClient client;


    @Override
    public List<OrderInfo> getOrderInfo() {
//        SearchRequest searchRequest = new SearchRequest("order_index");
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
//        searchRequest.source(searchSourceBuilder);
//        ArrayList<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
//        try {
//            SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
//            if (search!=null) {
//                for (SearchHit hit : search.getHits().getHits()) {
//                    JSON.toJSONString(hit.getSourceAsMap());
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return mapper.findOrderInfo();
    }

    public List<Map<String, Object>> getOrderInfoFuzzy(int pageNo, int pageSize, QueryWrapper queryWrapper) throws IOException {

        // 分页， 如果传入的页码为非法数值，设置为1
        if (pageNo <= 0){
            pageNo = 1 ;
        }
        SearchRequest searchRequest = new SearchRequest("order_index");
        // 查询资源构建器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 构建分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);
        // 构建模糊查询字段
        if(!StringUtils.isEmpty(queryWrapper.getCourseInfo())){
            searchSourceBuilder.query(QueryBuilders.matchQuery("courseInfo",queryWrapper.getCourseInfo()));
        }

        if(!StringUtils.isEmpty(queryWrapper.getOrderNum())){
            searchSourceBuilder.query(QueryBuilders.matchQuery("orderNum",queryWrapper.getOrderNum()));
        }

        if(!StringUtils.isEmpty(queryWrapper.getOrderStatus())){
            searchSourceBuilder.query(QueryBuilders.matchQuery("orderStatus",queryWrapper.getOrderStatus()));
        }

        if(!StringUtils.isEmpty(queryWrapper.getPayName())){
            searchSourceBuilder.query(QueryBuilders.matchQuery("payName",queryWrapper.getPayName()));
        }



        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);

        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        for (SearchHit hit : search.getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            maps.add(sourceAsMap);
        }

        return maps ;
    }
}
