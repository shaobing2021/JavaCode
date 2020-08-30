package com.realization;

import com.realization.service.OrderService;
import com.spring.SpringApplicationContext;

public class MainRealize {

    public static void main(String[] args) {
        //启动spring
        SpringApplicationContext context = new SpringApplicationContext(SpringConfig.class);
        //getBean
//        OrderService orderService =(OrderService) context.getBean("orderService");
//        System.out.println(context);
        System.out.println(context.getBean("orderService"));
//        System.out.println(context.getBean("orderService"));
//        System.out.println(context.getBean("orderService"));
//        orderService.test();
    }
}
