package com.qf.j2003;

import com.alibaba.fastjson.JSON;
import com.qf.j2003.order.mapper.OrderInfoMapper;
import com.qf.j2003.order.mapper.TbOrderMapper;
import com.qf.j2003.order.pojo.OrderInfo;
import com.qf.j2003.order.pojo.QueryWrapper;
import com.qf.j2003.order.pojo.TbTeacher;
import com.qf.j2003.order.service.OrderInfoService;
import com.qf.j2003.order.service.TbTeacherService;
import com.qf.j2003.order.service.impl.OrderInfoServiceImpl;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class J2003LeenOrderModelApplicationTests {

    @Autowired
    TbOrderMapper mapper ;
    @Autowired(required = false)
    OrderInfoServiceImpl orderInfoService ;

    @Autowired
    OrderInfoMapper orderInfoMapper ;

    @Autowired
    private TbTeacherService tbTeacherService ;

    @Autowired
    private OrderInfoService service ;

    @Autowired
    private RestHighLevelClient client ;


    @Test
    void testSearch() throws IOException {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setPayName("歌");
        queryWrapper.setCourseInfo("三角形");
        List<Map<String, Object>> orderInfo = orderInfoService.getOrderInfoFuzzy(
                1, 5, queryWrapper);

        for (Map<String, Object> stringObjectMap : orderInfo) {
            System.out.println(stringObjectMap);
        }
    }


    @Test
    public void contextLoads1() throws IOException {

        CreateIndexRequest request = new CreateIndexRequest("order_index");
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        System.out.println(response.toString());

    }

    @Test
    void contextLoads() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(1602604800000L);
        String format1 = format.format(date);
        System.out.println(format1);
    }

    @Test
    void testFindOrderInfo(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<OrderInfo> orderInfo = orderInfoMapper.findOrderInfo();
        for (OrderInfo info : orderInfo) {
            String format1 = format.format(info.getPayTime());

        }
    }

    @Test
    void testOrderInfo() {
        List<OrderInfo> orderInfo = service.getOrderInfo();
        orderInfo.forEach(System.out::println);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("5m");
        for(int i = 0 ; i < orderInfo.size(); i++){
            bulkRequest.add(new IndexRequest("order_index")
                    .id(""+(i+1))
                    .source(JSON.toJSONString(orderInfo.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = null;
        try {
            bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(!bulk.hasFailures());
        } catch (IOException e) {
            e.printStackTrace();
        }


        // orderInfo.forEach(System.out::println);
    }

    @Test
    void testGet() throws IOException {
        GetRequest getRequest = new GetRequest("order_index", "3");
//        getRequest.fetchSourceContext(new FetchSourceContext(false));
//        getRequest.storedFields("_none_");
        GetResponse fields = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> source = fields.getSource();

        String string = JSON.toJSONString(fields.getSource());
        System.out.println(string);
//        OrderInfo parse = (OrderInfo) JSON.parse(string);
//        System.out.println(parse);
    }


    @Test
    void testTeacherService(){
        List<TbTeacher> list = tbTeacherService.list(null);
        list.forEach(System.out::println);
    }


    @Test
    void testMatch() throws IOException {
        SearchRequest request = new SearchRequest("order_index");
        SearchSourceBuilder builder = new SearchSourceBuilder() ;

        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();

        builder.query(matchAllQueryBuilder);

        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(builder);

        SearchResponse search = client.search(request, RequestOptions.DEFAULT);

        for (SearchHit hit : search.getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            Object payTime =sourceAsMap.get("payTime");

            System.out.println(payTime);
            String string = JSON.toJSONString(sourceAsMap);

            System.out.println(string);
            JSON.parse(string);
        }
    }

    @Test
    void testCreateIndex() throws IOException {
        String index = "my_index";
        String type = "none_type";

        // 关于索引的settings
        Settings.Builder setting = Settings.builder()
                .put("number_of_shards", 3)
                .put("number_of_replicas", 1);

        // 关于索引的结构mappings
        XContentBuilder mappings = JsonXContent.contentBuilder()
                .startObject()
                    .startObject("properties")
                        .startObject("name")
                            .field("type", "text")
                        .endObject()
                        .startObject("age")
                            .field("type", "integer")
                        .endObject()
                        .startObject("birth")
                            .field("type", "date")
                            .field("format", "yyyy-MM-dd")
                        .endObject()
                    .endObject()
                .endObject();

        // 将settings, 和mappings 封装到一个Request 对象
        CreateIndexRequest request = new CreateIndexRequest(index).settings(setting).mapping(type,mappings);

        client.indices().create(request, RequestOptions.DEFAULT);
    }

}
