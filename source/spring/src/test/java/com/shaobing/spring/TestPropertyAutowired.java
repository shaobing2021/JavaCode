package com.shaobing.spring;

import com.shaobing.spring.config.MainConfigOfAutowired;
import com.shaobing.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPropertyAutowired {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    public void test01(){
        printBeans();

        BookService bookService = context.getBean(BookService.class);
        System.out.println(bookService);
    }
    public void printBeans(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
