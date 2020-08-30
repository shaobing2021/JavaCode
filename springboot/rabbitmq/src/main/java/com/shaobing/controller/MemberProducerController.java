package com.shaobing.controller;

import com.shaobing.email.FanoutEmailProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberProducerController {
    @Autowired
    private FanoutEmailProducer fanoutEmailProducer;
    @RequestMapping("/sendMsg")
    public String sendMsg(String queueName){
        fanoutEmailProducer.send(queueName);
        return "success";
    }
}
