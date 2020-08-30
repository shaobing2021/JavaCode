package com.shaobing.email;

import org.springframework.stereotype.Component;

@Component
public class EmailCustomer {
    public void email(String msg){
        System.out.println("email:"+msg);
    }
}
