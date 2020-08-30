package com.shaobing.spring.bean;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;
@Component
public class Elemphant {
    public Elemphant() {
        System.out.println("ele...constructor...");
    }
//    @PostConstruct
    public void init(){
        System.out.println("ele...init...");
    }
//    @PreDestroy
    public void destroy(){
        System.out.println("ele...destroy...");
    }
}
