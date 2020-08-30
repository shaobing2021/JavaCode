package com.shaobing.spring;


import com.shaobing.spring.bean.Person;
import com.shaobing.spring.config.MyConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class TestXml {
    @Test
    public void  test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person bean = context.getBean("person", Person.class);
        System.out.println(bean);
    }

    public void testConfig(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Person bean = context.getBean(Person.class);
//        获取bean
        System.out.println(bean);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
//        获取id
        for (String s : beanNamesForType) {
            System.out.println(s);//在myconfig中bean("aa")，则名字为aa，否则为方法名GetPerson
        }
    }

    public void testNams(){
//        这就是容器，注册bean
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    public void testPrototype(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Object p1 = context.getBean("person");
        Object p2 = context.getBean("person");
        System.out.println(p1==p2);
    }

    public void testConditional(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//        通过类型获取bean的名字，有三种bean。还有就是获取容器中所有名字
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
//        获取所有bean对象
        Map<String, Person> persons = context.getBeansOfType(Person.class);
        System.out.println(persons);
//        获取系统环境名字
//        Environment environment = context.getEnvironment();
//        String property = environment.getProperty("os.name");
//        System.out.println(property);//windows 10
    }
    @Test
    public void testImport(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);//包含colorFactoryBean
        }
        Object bean = context.getBean("colorFactoryBean");
        Object bean1 = context.getBean("&colorFactoryBean");
        System.out.println(bean.getClass());//class com.shaobing.spring.bean.Color
        System.out.println(bean1.getClass());//class com.shaobing.spring.bean.ColorFactoryBean
    }
}
