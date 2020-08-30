package com.shaobing.spring.dao;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookDao {
    private String label = "1";
    public void print(){
        System.out.println("输出....");
    }
}
