package com.shaobing.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Blog {
    private int id;
    private String title;
    private String description;
    private String content;
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created;
    private int status;
    private int sid;
}
