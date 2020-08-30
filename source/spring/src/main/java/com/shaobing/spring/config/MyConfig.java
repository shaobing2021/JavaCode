package com.shaobing.spring.config;

import com.shaobing.spring.bean.Color;
import com.shaobing.spring.bean.ColorFactoryBean;
import com.shaobing.spring.bean.Dog;
import com.shaobing.spring.bean.Person;
import com.shaobing.spring.condition.LinuxCondition;
import com.shaobing.spring.condition.MyImportBeanDefinitionRegistrar;
import com.shaobing.spring.condition.MyImportSelector;
import com.shaobing.spring.condition.WindosCondition;
import org.springframework.context.annotation.*;


//代表这是一个配置类
@Configuration
//导入多个组件，id默认是组件的全类名
@Import({Color.class, Dog.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MyConfig {
    @Bean
    public Person person(){
        return new Person("李四",22);
    }

    @Conditional({LinuxCondition.class})
    @Bean()
    public Person person01(){
        return new Person("linux",88);
    }
    @Bean()
    @Conditional(WindosCondition.class)
    public Person person02(){
        return new Person("windows",66);
    }
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}