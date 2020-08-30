package com.shaobing.hello;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
            exchange = @Exchange(type = "topic",name = "topics"),
            key = {"user.save","user.*"})
    })
    public void receive1(String message){
        System.out.println("message1："+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(type = "topic",name = "topics"),
                    key = {"user.save","order.*"})
    })
    public void receive2(String message){
        System.out.println("message2："+message);
    }
}
