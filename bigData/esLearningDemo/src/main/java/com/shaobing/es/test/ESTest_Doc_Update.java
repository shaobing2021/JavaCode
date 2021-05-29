package com.shaobing.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.es.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Update {
    public static void main(String[] args) throws IOException {

        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("d1").id("1001");
        updateRequest.doc(XContentType.JSON,"sex","gay");
        UpdateResponse response = esClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
        esClient.close();
    }
}
