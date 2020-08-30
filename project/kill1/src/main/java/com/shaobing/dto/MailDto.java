package com.shaobing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDto implements Serializable {
    //主题
    private String subject;
    //内容
    private String content;
    //接收人
    private String[] tos;
}
