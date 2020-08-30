package com.shaobing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class RabbitmqApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("hello","helloworld");
    }
    @Test
    void testwork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello work"+i);
        }
    }
    @Test
    void testFanout() {
        rabbitTemplate.convertAndSend("logs","","hello fanout");
    }
    @Test //路由模式
    void testRoute() {
        rabbitTemplate.convertAndSend("directs","error","hello directs info");
    }
    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("topics","order.save","user.save key ");
    }
    @Autowired
    private ObjectMapper mapper;
    @Test
    void testJackson(){
        User user = new User();
        user.setUsername("罗");
        user.setPassword("456");
        user.setTime(LocalDateTime.now());
//        mapper.registerModule(new JavaTimeModule());
        String s = null;
        try {
             s = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("s:"+s);
        User u = null;;
        try {
             u = mapper.readValue(s, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("u:"+u);
    }
    @Test
    public void testLocal(){
        User user = new User();
        user.setUsername("罗");
        user.setPassword("456");
        user.setTime(LocalDateTime.now());
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
//        mapper.registerModule(JavaTimeModule);
    }
    @Test
    public void test(){
        System.out.println(LocalDateTime.now());
    }
}
