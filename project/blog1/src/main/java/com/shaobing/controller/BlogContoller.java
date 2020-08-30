package com.shaobing.controller;

import com.shaobing.common.Result;
import com.shaobing.dao.BlogMapper;
import com.shaobing.pojo.Blog;
import com.shaobing.pojo.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BlogContoller {
//    private static final Logger LOGGER = LoggerFactory.getLogger(BlogContoller.class);
    @Autowired
    BlogMapper blogMapper;
    @RequestMapping("/blogList/{sid}/{currentPage}/{pageSize}")
    public Result getblogs(@PathVariable int sid,@PathVariable int currentPage,@PathVariable int pageSize){
        List<Blog> blogs = blogMapper.getBlogsBySid(sid, (currentPage - 1) * pageSize, pageSize);
        if (blogs!=null){
            PageResult pageResult = new PageResult(blogMapper.getBlogsRows(sid),blogs);
            return Result.succ(pageResult);
        }
        System.out.println("查询BlogList:"+sid);
        return Result.fail("获取当前博客列表失败");
    }
    @RequestMapping("/blog/{id}")
    public Result getblog(@PathVariable int id){
        Blog blog = blogMapper.getBlogById(id);
        if (blog!=null){
            return Result.succ(blog);
        }
        return Result.fail("获取当前博客失败");
    }
}
