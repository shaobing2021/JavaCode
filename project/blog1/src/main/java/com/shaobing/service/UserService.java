package com.shaobing.service;

import com.shaobing.dao.IUserMapper;
import com.shaobing.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserMapper mapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public User getUserById(int i) {
        return mapper.getUserById(i);
    }

    @Override
    public User getUserByMessage(String username, String password) {
        password = bCryptPasswordEncoder.encode(password);
        System.out.println("UserService:username="+username+"--password:"+password);
        return mapper.getUserByMessage(username,password);
    }
}
