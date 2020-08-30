package com.shaobing.spring;

import com.shaobing.spring.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestLifeCycle {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);

    public void test1(){

        System.out.println("容器创建完成...");
        Object car = context.getBean("car");
        Object car1 = context.getBean("car");
        System.out.println(car);
        System.out.println(car1);
//        关闭容器
        context.close();
    }

    public void test2(){
        System.out.println("容器创建完成");
        context.close();
    }
}
