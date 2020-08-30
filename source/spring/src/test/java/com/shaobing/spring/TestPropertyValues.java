package com.shaobing.spring;

import com.shaobing.spring.bean.Person;
import com.shaobing.spring.config.MainConfigOfPropertyValues;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class TestPropertyValues {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    public void test01(){
        printBeans();
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.NickName");
        System.out.println(property);
        context.close();
    }
    public void printBeans(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
