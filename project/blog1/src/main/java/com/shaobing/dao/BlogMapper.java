package com.shaobing.dao;

import com.shaobing.pojo.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogMapper {
//    获取某个类别下所有博客
    List<Blog> getBlogBySid(int sid);
//    获取某篇博客
    Blog getBlogById(int id);
//    根据偏移量和每页条数获取博客
    List<Blog> getBlogsBySid(int sid, int offset, int limit);
//    获取类别下博客数量
    int getBlogsRows(int sid);
    
}
