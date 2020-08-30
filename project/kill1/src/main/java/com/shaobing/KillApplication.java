package com.shaobing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.shaobing.dao")
@EnableScheduling
public class KillApplication {

    public static void main(String[] args) {
        SpringApplication.run(KillApplication.class, args);
    }

}
