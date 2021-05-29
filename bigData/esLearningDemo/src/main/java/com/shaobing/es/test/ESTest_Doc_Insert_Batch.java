package com.shaobing.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.es.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));
        //批量插入数据
        BulkRequest request = new BulkRequest();
        User u1 = new User("张三", "男", 30);
        User u2 = new User("里斯", "男", 12);
        User u3 = new User("王五", "男", 34);
        User u4 = new User("五", "男", 10);
        User u5 = new User("王", "男", 9);
        User u6 = new User("力", "男", 8);
        String u11 = new ObjectMapper().writeValueAsString(u1);
        String u22 = new ObjectMapper().writeValueAsString(u2);
        String u33 = new ObjectMapper().writeValueAsString(u3);
        String u44 = new ObjectMapper().writeValueAsString(u4);
        String u55 = new ObjectMapper().writeValueAsString(u5);
        String u66 = new ObjectMapper().writeValueAsString(u6);
        IndexRequest s1 = new IndexRequest().index("d1").id("1001").source(u11,XContentType.JSON);
        IndexRequest s2 = new IndexRequest().index("d1").id("1002").source(u22,XContentType.JSON);
        IndexRequest s3 = new IndexRequest().index("d1").id("1003").source(u33,XContentType.JSON);
//        IndexRequest s4 = new IndexRequest().index("d1").id("1004").source(XContentType.JSON, u44);
//        IndexRequest s5 = new IndexRequest().index("d1").id("1005").source(XContentType.JSON, u55);
//        IndexRequest s6 = new IndexRequest().index("d1").id("1006").source(XContentType.JSON, u66);
        request.add(s1);
        request.add(s2);
        request.add(s3);
//        request.add(s4);
//        request.add(s5);
//        request.add(s6);
        //批量插入数据
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());
        esClient.close();
    }
}
