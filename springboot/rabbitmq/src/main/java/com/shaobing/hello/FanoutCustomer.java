package com.shaobing.hello;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//广播消费
@Component
public class FanoutCustomer {
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(),//创建临时队列
            exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void receive1(String message){
        System.out.println("message1:"+message);
    }
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "logs",type = "fanout"))
    })
    public void receive2(String message){
        System.out.println("message2:"+message);
    }
}
