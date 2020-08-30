package com.shaobing.service;

import com.shaobing.dao.BlogMapper;
import com.shaobing.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Override
    public List<Blog> getBlogsBySid(int sid, int offset, int limit) {
        List<Blog> blogsBySid = blogMapper.getBlogsBySid(sid, offset, limit);
        return blogsBySid;
    }

    @Override
    public int getBlogsRows(int sid) {
        return blogMapper.getBlogsRows(sid);
    }
}
