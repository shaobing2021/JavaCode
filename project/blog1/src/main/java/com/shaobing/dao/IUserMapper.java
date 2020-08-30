package com.shaobing.dao;

import com.shaobing.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserMapper {
    User getUserById(int i);
    int addUser(User user);
    int getByName(User user);

    /**
     * 根据用户名密码登录
     * @param username
     * @param password
     * @return
     */
    User getUserByMessage(@Param("username") String username,@Param("password") String password);
}
