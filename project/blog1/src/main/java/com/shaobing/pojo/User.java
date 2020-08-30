package com.shaobing.pojo;

import lombok.Data;

@Data
public class User {
//    自增id,用户名,头像,密码,邮箱,角色,状态
    private Integer id;
    private String username;
    private String avatar;
    private String password;
    private String email;
    private String role;
    private boolean state;

}
