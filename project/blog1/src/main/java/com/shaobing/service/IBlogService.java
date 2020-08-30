package com.shaobing.service;

import com.shaobing.pojo.Blog;

import java.util.List;

public interface IBlogService {
    //    根据偏移量和每页条数获取博客
    List<Blog> getBlogsBySid(int sid, int offset, int limit);
    //    获取类别下博客数量
    int getBlogsRows(int sid);
}
