package com.shaobing.dao;

import com.shaobing.pojo.User;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserDao {
    User getUserById(int id);
    List<User> getUsers(int id);
}
