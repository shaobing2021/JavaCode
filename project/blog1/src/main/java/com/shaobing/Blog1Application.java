package com.shaobing;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
@MapperScan("com.shaobing.dao")
public class Blog1Application {

    public static void main(String[] args) {
        SpringApplication.run(Blog1Application.class, args);
    }

}
