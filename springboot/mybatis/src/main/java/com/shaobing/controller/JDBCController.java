package com.shaobing.controller;

import com.shaobing.dao.UserDao;
import com.shaobing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private UserDao userDao;
    @RequestMapping("/user")
    public List<Map<String, Object>> users(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @RequestMapping("/user/{id}")
    public User user(@PathVariable int id){
        User user = userDao.getUserById(id);
        return user;
    }
}
