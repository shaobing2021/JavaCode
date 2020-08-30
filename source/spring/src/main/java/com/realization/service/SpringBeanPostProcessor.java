package com.realization.service;

import com.spring.BeanPostProcessor;
import com.spring.SComponent;

@SComponent
public class SpringBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前的逻辑..."+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后的逻辑..."+beanName);
        return bean;
    }
}
