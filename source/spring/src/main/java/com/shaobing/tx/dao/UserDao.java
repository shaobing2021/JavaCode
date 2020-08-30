package com.shaobing.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into user (id,username,password) values (?,?,?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        String password = UUID.randomUUID().toString().substring(5, 11);
        jdbcTemplate.update(sql,null,username,password);
    }
}
