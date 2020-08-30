package com.shaobing.controller;

import com.shaobing.common.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public Result test(){
        return Result.succ("hello");
    }

}
