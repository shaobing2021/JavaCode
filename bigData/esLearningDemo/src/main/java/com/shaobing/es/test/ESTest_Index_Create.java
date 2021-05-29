package com.shaobing.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class ESTest_Index_Create {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));

        CreateIndexRequest request = new CreateIndexRequest("d1");
        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("index option:"+ acknowledged);
        //创建索引
        esClient.close();
    }
}
