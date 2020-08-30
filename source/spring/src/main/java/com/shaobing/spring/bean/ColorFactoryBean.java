package com.shaobing.spring.bean;

import org.springframework.beans.factory.FactoryBean;
//创建一个spring定义的factoryBean
public class ColorFactoryBean implements FactoryBean<Color> {
    //返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
//true单表是单实例，容器中只保存一份，false表示多实例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
