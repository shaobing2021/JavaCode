package com.shaobing.spring.di;

public class UserController {
    @Autowired
    private UserService userService;


    public UserService getUserService() {
        return userService;
    }
}
