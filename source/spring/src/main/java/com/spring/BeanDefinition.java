package com.spring;

import lombok.Data;

@Data
public class BeanDefinition {
    //单例多例
    private String scope;
    //对象类型
    private Class beanClass;
    //是否懒加载

}
