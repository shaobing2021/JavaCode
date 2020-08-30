package com.shaobing.email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.pojo.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class FanoutEmailProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send(String queueName){
        User user = new User();
        user.setPassword("12345");
        user.setUsername("hello");
        user.setTime(LocalDateTime.now());
        System.out.println("queueName:" +queueName);
        //发送消息
        ObjectMapper mapper = new ObjectMapper();
        String s = null;
        try {
            s = mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(s.getBytes());
        rabbitTemplate.convertAndSend(queueName,s.getBytes());
    }
}
