package com.shaobing.tx;

import com.shaobing.tx.config.TxConfig;
import com.shaobing.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {

    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService service = context.getBean(UserService.class);
        service.insert();
        System.out.println("-------");
    }
}
