package com.shaobing.spring.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LinuxCondition implements Condition {

    /**
     * conditionContext:判断条件能使用的上下文环境
     * AnnotatedTypeMetadata:注释信息
     * @param context
     * @param metadata
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        1.获取ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
//        2.获取类加载器
        ClassLoader classLoader = context.getClassLoader();
//        3.获取当前环境
        Environment environment = context.getEnvironment();
//        4.获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();
//        可以判断bean注册情况，也可以给容器中注册bean
        boolean definition = registry.containsBeanDefinition("person");
        String property = environment.getProperty("os.name");

        return property.contains("linux");
    }
}
