package com.shaobing.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Delete_Batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));
        //批量插入数据
        BulkRequest request = new BulkRequest();
        DeleteRequest d1 = new DeleteRequest().index("d1").id("1001");
        DeleteRequest d2 = new DeleteRequest().index("d1").id("1002");
        DeleteRequest d3 = new DeleteRequest().index("d1").id("1003");

        request.add(d1);
        request.add(d2);
        request.add(d3);
        //批量插入数据
        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());
        esClient.close();
    }
}
