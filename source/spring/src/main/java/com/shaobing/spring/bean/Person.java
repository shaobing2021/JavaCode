package com.shaobing.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Value("${person.NickName}")
    private String name;
    @Value("#{20-1}")
    private int age;
    
}
