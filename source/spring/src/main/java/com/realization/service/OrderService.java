package com.realization.service;

import com.spring.*;

@SComponent("orderService")
@Scope("singleton")
public class OrderService implements InitializingBean , BeanNameAware {
    @SAutowired
    private UserService userService;

    private String beanName;
    public void test(){
        System.out.println(userService);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("初始化....");
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println(beanName);
    }
}
