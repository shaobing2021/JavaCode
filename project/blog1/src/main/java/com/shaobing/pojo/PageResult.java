package com.shaobing.pojo;

import java.util.List;

public class PageResult {
//    总共多少页
    private int total ;
//    设置数据
    private List<?> records;

    public PageResult() {
    }

    public PageResult(int total, List<?> records) {
        this.total = total;
        this.records = records;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRecords() {
        return records;
    }

    public void setRecords(List<?> records) {
        this.records = records;
    }
}
