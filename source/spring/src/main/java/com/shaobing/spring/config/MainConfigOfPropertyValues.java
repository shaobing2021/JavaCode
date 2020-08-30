package com.shaobing.spring.config;


import com.shaobing.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//导入读取外部配置文件的环境
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValues {
    @Bean
    public Person person(){
        return new Person();
    }
}
