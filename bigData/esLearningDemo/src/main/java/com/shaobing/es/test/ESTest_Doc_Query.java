package com.shaobing.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.es.pojo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;

/**
 * 高级查询：查询所有档案，条件查询，分页查询，排序查询，过滤查询
 */
public class ESTest_Doc_Query {

    private static RestHighLevelClient esClient = new RestHighLevelClient(
            RestClient.builder(new HttpHost("192.168.11.130",9200,"http")));
    public static void main(String[] args) throws IOException {
//        searchAll();
//        searchCondition();
    //    searchPage();
        //searchSort();
//        searchFilter();
//        queryCombination();
//        searchRange();
//        searchblur();
//        searchHighlight();
        searchAggregation();
        searchGroup();
        esClient.close();
    }
    //全量查询
    private static void searchAll() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        request.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //条件查询
    private static void searchCondition() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("name","张三")));
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //分页查询
    private static void searchPage() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "30"));
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.from(0);
        builder.size(2);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //查询排序
    private static void searchSort() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "30"));
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.ASC);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //过滤排序
    private static void searchFilter() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "30"));
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        String[] excludes = {};
        String[] includes = {"name"};
        builder.fetchSource(includes,excludes);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //组合排序
    private static void queryCombination() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "30"));
        
        SearchSourceBuilder builder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("age",12));
        //boolQueryBuilder.must(QueryBuilders.matchQuery("sex","男"));
        boolQueryBuilder.should(QueryBuilders.matchQuery("age",30));
        //        boolQueryBuilder.must(QueryBuilders.matchQuery("age",30));
        builder.query(boolQueryBuilder);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //范围查询
    private static void searchRange() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.termQuery("age", "30"));

        SearchSourceBuilder builder = new SearchSourceBuilder();
        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        //大于等于，小于
        rangeQuery.gte(12);
        rangeQuery.lt(30);
        builder.query(rangeQuery);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }

    //模糊查询
    private static void searchblur() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.fuzzyQuery("name","张三").fuzziness(Fuzziness.ONE));
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
//高亮查询
    private static void searchHighlight() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "张三123");
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");
        highlightBuilder.field("name");
        builder.highlighter(highlightBuilder);
        builder.query(termQueryBuilder);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //聚合查询
    private static void searchAggregation() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
        builder.aggregation(aggregationBuilder);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
    //分组查询
    private static void searchGroup() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("d1");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation(aggregationBuilder);
        request.source(builder);
        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
    }
}
