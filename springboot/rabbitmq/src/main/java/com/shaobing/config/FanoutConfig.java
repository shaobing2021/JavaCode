package com.shaobing.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
//注入到spring容器种
@Component
public class FanoutConfig {
    //定义邮件队列
    private String FANOUT_EMAIL_QUEUE = "emailQueue";
    //定义交换机名称
    private String EXCHANGE_NAME = "fanoutExchange";
    //1.定义邮件队列
    @Bean
    public Queue fanoutEmailQueue(){
        return new Queue(FANOUT_EMAIL_QUEUE);
    }
    //2.定义交换机,想使用什么交换机就绑定什么交换机
    @Bean
   public FanoutExchange fanoutExchange(){
        return new FanoutExchange(EXCHANGE_NAME);
    }
    //3.交换机和队列绑定 参数名称和定义队列和交换机方法名称一致
    @Bean
    public Binding bindExchangeEmail(Queue fanoutEmailQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
    }
}
