package com.shaobing.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
//代表是一个监听者，没有队列，声明一个队列，默认持久化 非独占(独占影响效率) 非自动删除队列
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class HelloCustomer {
    /**
     * 代表回调方法
     * @param message
     */
    @RabbitHandler
    public void receive(String message){
        System.out.println(message);
    }
}
