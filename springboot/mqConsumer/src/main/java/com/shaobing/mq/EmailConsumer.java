package com.shaobing.mq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.mq.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "emailQueue")
    public void email(String user){
        ObjectMapper mapper = new ObjectMapper();
        User u = null;
        try {
            u = mapper.readValue(user, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("email：" +u);
    }

}
