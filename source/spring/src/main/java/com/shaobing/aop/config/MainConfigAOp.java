package com.shaobing.aop.config;

import com.shaobing.aop.aop.LogAspects;
import com.shaobing.aop.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigAOp {
    //业务逻辑类加入容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }
    //切面加入容器,使用注解方式注入，导入应该也可以
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}