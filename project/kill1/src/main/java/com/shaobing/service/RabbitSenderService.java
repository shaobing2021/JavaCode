package com.shaobing.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.dao.ItemKillSuccessMapper;
import com.shaobing.pojo.KillSuccessUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RabbitSenderService {
    private static final Logger log = LoggerFactory.getLogger(RabbitSenderService.class);
    @Autowired
    private ObjectMapper mapper ;
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendKillSuccesssEmailMsg(String orderNo) {
        if (orderNo!=null&&orderNo.length()!=0){
            KillSuccessUserInfo info = itemKillSuccessMapper.selectByCode(orderNo);
            if (info!=null){
                //将info消息发送至队列
                String infoJson = null;
                try {
                    infoJson = mapper.writeValueAsString(info);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                rabbitTemplate.convertAndSend("kill1", "",infoJson);
                log.info(infoJson);
            }
        }
    }

    /**
     * 秒杀成功生成抢购订单，发送消息入私信队列，等待一定时间失效超时未支付订单
     * @param orderCode
     */
//    public void sendKillSuccessOrderExpireMsg(final String orderCode){
//        if (!StringUtils.isEmpty(orderCode)){
//            KillSuccessUserInfo info = itemKillSuccessMapper.selectByCode(orderCode);
//            if (info!=null){
//                log.info("发送消息至死信队列...");
//                String s = null;
//                try {
//                    s = mapper.writeValueAsString(info);
//                } catch (JsonProcessingException e) {
//                    e.printStackTrace();
//                }
////                rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
//                rabbitTemplate.setExchange("success.kill.prod.exchange");
//                rabbitTemplate.setRoutingKey("success.kill.prod.routing.key");
//                rabbitTemplate.convertAndSend((Object) s, new MessagePostProcessor() {
//                    @Override
//                    public Message postProcessMessage(Message message) throws AmqpException {
//                        MessageProperties mp = message.getMessageProperties();
////                        mp.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
////                        mp.setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME,KillSuccessUserInfo.class);
//                        mp.setExpiration("100000");
//                        return message;
//                    }
//                });
//            }
//        }
//
//    }
    public void sendKillSuccessOrderExpireMsg(final String orderCode){
        if (!StringUtils.isEmpty(orderCode)){
            KillSuccessUserInfo info = itemKillSuccessMapper.selectByCode(orderCode);
            if (info!=null){
                log.info("发送消息至死信队列...");
                String s = null;
                try {
                    s = mapper.writeValueAsString(info);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                rabbitTemplate.convertAndSend("success.kill.prod.exchange","success.kill.prod.routing.key",s);
            }
        }
    }
}
