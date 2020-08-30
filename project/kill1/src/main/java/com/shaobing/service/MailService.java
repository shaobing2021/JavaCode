package com.shaobing.service;

import com.shaobing.dto.MailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableAsync
public class MailService {
    @Autowired
    private JavaMailSenderImpl mailSender;
    private static final Logger log = LoggerFactory.getLogger(MailService.class);
    @Async
    public void sendSimpleEmail(final MailDto mailDto){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("403001592@qq.com");
        message.setTo(mailDto.getTos());
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getContent()+ LocalDateTime.now());
        mailSender.send(message);
        log.info("发送邮件成功...");
    }
}
