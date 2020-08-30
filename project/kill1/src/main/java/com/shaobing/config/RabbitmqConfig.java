package com.shaobing.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Slf4j
@Configuration
public class RabbitmqConfig {
    private final String Kill_Dead_Queue = "success.kill.dead.queue";
    private final String Kill_Real_Queue = "success.kill.real.queue";
    private final String Kill_Dead_Exchange = "success.kill.dead.exchange";
    private final String Kill_Prod_Exchange = "success.kill.prod.exchange";
    private final String Kill_Dead_Routting_Key= "success.kill.dead.routing.key";
    private final String Kill_Prod_Routting_Key= "success.kill.prod.routing.key";
    private final Integer Expire_Time = 10000000;

    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private SimpleRabbitListenerContainerFactoryConfigurer factoryConfigurer;

    @Bean(name = "singleListenerContainer")
    public SimpleRabbitListenerContainerFactory listenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setConcurrentConsumers(1);
        factory.setMaxConcurrentConsumers(1);
        factory.setPrefetchCount(1);
        factory.setTxSize(1);
        return factory;
    }

    /**
     * 多个消费者
     * @return
     */
    @Bean(name = "multiListenerContainer")
    public SimpleRabbitListenerContainerFactory multiListenerContainer(){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factoryConfigurer.configure(factory,connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        //确认消费模式-NONE
        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
        factory.setConcurrentConsumers(20);
        factory.setMaxConcurrentConsumers(30);
        factory.setPrefetchCount(15);
        return factory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
            }
        });
        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
                log.warn("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
            }
        });
        return rabbitTemplate;
    }


    //1.死信交换机+死信路由==>死信队列
    @Bean
    public Queue successKillDeadQueue(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", Kill_Dead_Exchange);
        args.put("x-dead-letter-routing-key", Kill_Dead_Routting_Key);
        args.put("x-message-ttl",Expire_Time);//单位ms,配置时间
        return new Queue(Kill_Dead_Queue,true,false,false,args);
    }
    //2.基本交换机
    @Bean
    public TopicExchange successKillDeadProdExchange(){
        return new TopicExchange(Kill_Prod_Exchange);
    }
    //3.基本交换机+基本路由==>死信队列
    @Bean
    public Binding successKillDeadProdBinding(){
        return BindingBuilder.bind(successKillDeadQueue()).to(successKillDeadProdExchange()).with(Kill_Prod_Routting_Key);
    }
    //4.真正队列
    @Bean
    public Queue successKillRealQueue(){
        return new Queue(Kill_Real_Queue);
    }
    //5.死信交换机
    @Bean
    public TopicExchange successKillDeadExchange(){
        return new TopicExchange(Kill_Dead_Exchange);
    }
    //6.死信交换机+死信路由==>真正队列
    @Bean
    public Binding successKillDeadBinding(){
        return BindingBuilder.bind(successKillRealQueue()).to(successKillDeadExchange()).with(Kill_Dead_Routting_Key);
    }
}
