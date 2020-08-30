package com.shaobing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override

    public void addCorsMappings(CorsRegistry registry) {
//        允许跨域路径
        registry.addMapping("/**")
//                允许跨域来源
                .allowedOrigins("*")
//                允许跨域方法六个
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                是否携带信息(token)
                .allowCredentials(true)
//                最大时间(生命周期)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}