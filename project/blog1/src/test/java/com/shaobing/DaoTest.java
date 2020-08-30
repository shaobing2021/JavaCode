package com.shaobing;

import com.shaobing.dao.BlogMapper;
import com.shaobing.dao.IUserMapper;
import com.shaobing.dao.MenuMapper;
import com.shaobing.pojo.Blog;
import com.shaobing.pojo.MainMenu;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
public class DaoTest {
    @Autowired
    private IUserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    void testMenu(){
        List<MainMenu> menus = menuMapper.getMenus();
        System.out.println(menus);
    }
    @Test
    void testSelect(){
        int c = blogMapper.getBlogsRows(3);
        System.out.println(c);
        List<Blog> blogsBySid = blogMapper.getBlogsBySid(3, 0, 2);
        System.out.println(blogsBySid);
    }
    @Test
    void test1(){
        String password = "123456";
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);
        boolean matches = bCryptPasswordEncoder.matches(encode, password);
//        boolean matches1 = bCryptPasswordEncoder.matches(password, encode);
        boolean matches1 = bCryptPasswordEncoder.matches(password, "$2a$10$CkJYhQ/GFrm3VKNFZStsaud8LNrl7NhYdpPkkEL8l7kCmmUC3llle");
        System.out.println(matches);
        System.out.println(matches1);
    }
    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void testMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("主题");
        message.setText("内容");
        message.setTo("172140553@qq.com");
        message.setFrom("403001592@qq.com");
        mailSender.send(message);
    }
}
