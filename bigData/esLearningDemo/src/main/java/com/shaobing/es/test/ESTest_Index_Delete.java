package com.shaobing.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class ESTest_Index_Delete {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));

        DeleteIndexRequest request = new DeleteIndexRequest("d1");
        AcknowledgedResponse response = esClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("index option:"+ response.isAcknowledged());
        //创建索引
        esClient.close();
    }
}
