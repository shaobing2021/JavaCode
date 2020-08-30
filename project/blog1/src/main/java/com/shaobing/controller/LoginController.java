package com.shaobing.controller;

import com.shaobing.common.Result;
import com.shaobing.pojo.User;
import com.shaobing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        User u = userService.getUserByMessage(user.getUsername(), user.getPassword());
        if (u!=null){
            return Result.succ(user);
        }
        return Result.fail("用户名或密码错误");
    }
}
