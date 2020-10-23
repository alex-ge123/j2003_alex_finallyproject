package com.qf.j2003;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class MyTest {


    @Autowired
    RestHighLevelClient client ;

    public static void main(String[] args) throws IOException {


    }

}
