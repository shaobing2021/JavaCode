package com.shaobing.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.es.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Insert {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));
        IndexRequest request = new IndexRequest();
        request.index("d1").id("1001");
        User user = new User("张三", "男", 30);
        String userJson = new ObjectMapper().writeValueAsString(user);
        request.source(userJson, XContentType.JSON);
        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
        esClient.close();
    }
}
