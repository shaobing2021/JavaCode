package com.shaobing.spring.config;

import com.shaobing.spring.bean.Car;
import com.shaobing.spring.bean.Color;
import com.shaobing.spring.bean.Red;
import com.shaobing.spring.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration//,"com.shaobing.spring.bean"
@ComponentScan({"com.shaobing.spring.controller", "com.shaobing.spring.service", "com.shaobing.spring.dao"})
public class MainConfigOfAutowired {
    @Primary
    @Bean()
    public BookDao bookDao2(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
    @Bean
    public Red red(){
        return new Red();
    }
}
