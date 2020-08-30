package com.shaobing.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaobing.dao.ItemKillSuccessMapper;
import com.shaobing.dto.MailDto;
import com.shaobing.pojo.ItemKillSuccess;
import com.shaobing.pojo.KillSuccessUserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceiverService {
    private static final Logger log = LoggerFactory.getLogger(RabbitReceiverService.class);
    @Autowired
    private ObjectMapper mapper ;
    @Autowired
    private MailService mailService;
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "email"),
                    exchange = @Exchange(value = "kill1",type = "fanout"))
    })
    public void consumeEmailMsg(String msg) throws JsonProcessingException {
        KillSuccessUserInfo info = mapper.readValue(msg, KillSuccessUserInfo.class);
        log.info(info.toString());
        MailDto dto = new MailDto("抢购成功邮件...","抢购成功",new String[]{info.getEmail()});
        mailService.sendSimpleEmail(dto);
    }

    @RabbitListener(queues = {"success.kill.real.queue"})
    public void consumeExpireOrder(String msg) throws JsonProcessingException {
        KillSuccessUserInfo info = mapper.readValue(msg, KillSuccessUserInfo.class);
        log.info("超时监听...{}",info);
        if (info!=null){
            ItemKillSuccess itemKillSuccess = itemKillSuccessMapper.selectByPrimaryKey(info.getCode());
            if (itemKillSuccess!=null&&itemKillSuccess.getStatus().intValue()==0){
                itemKillSuccessMapper.expireOrder(info.getCode());
            }
        }
    }
}
