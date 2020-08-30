package com.shaobing.hello;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteCutomer {
    @RabbitListener(bindings ={
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    //默认type="direct"，因而可以省略,指定交换机名称和类型
                    exchange = @Exchange("directs"),
                    key={"info","error","warn"}
            )
    })
    public void receive1(String message){
        System.out.println("message1:"+message);
    }
    @RabbitListener(bindings ={
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    //默认type="direct"，因而可以省略,指定交换机名称和类型
                    exchange = @Exchange("directs"),
                    key={"error"}
            )
    })
    public void receive2(String message){
        System.out.println("message2:"+message);
    }
}
