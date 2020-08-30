package com.shaobing.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperConfig {
    @Bean
    public CuratorFramework curatorFramework(){
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("106.13.144.143:2181")
                .namespace("kill")
                .retryPolicy(new RetryNTimes(5, 1000))
                .build();
        curatorFramework.start();
        return curatorFramework;
    }
}
