package com.shaobing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
    }

    @Test
    void testJedis(){
        redisTemplate.opsForValue().set("k1","v1");
        Object k1 = redisTemplate.opsForValue().get("k1");
        System.out.println(k1);
    }
    @Test
    void test(){
        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("k1", "v2");
        System.out.println(aBoolean);
        Object k1 = redisTemplate.opsForValue().get("k1");
        Boolean res = redisTemplate.opsForValue().setIfAbsent("k", "v");
        System.out.println(res);
        System.out.println(k1);
        redisTemplate.expire("k1",30, TimeUnit.MINUTES);
        redisTemplate.expire("k",30, TimeUnit.MINUTES);
    }
}
