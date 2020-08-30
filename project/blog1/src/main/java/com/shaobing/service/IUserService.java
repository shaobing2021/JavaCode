package com.shaobing.service;

import com.shaobing.pojo.User;

public interface IUserService {
    User getUserById(int i);
    User getUserByMessage(String username,String password);
}
