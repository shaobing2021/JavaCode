package com.shaobing.spring.config;

import com.shaobing.spring.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.shaobing.spring.bean")
@Configuration
public class MainConfigOfLifeCycle {
    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
