package com.shaobing.controller;

import com.shaobing.common.Result;
import com.shaobing.dao.MenuMapper;
import com.shaobing.pojo.MainMenu;
import com.shaobing.pojo.SubMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuMapper menuMapper;
    @RequestMapping("/menus")
    public Result getMenus(){
        List<MainMenu> menus = menuMapper.getMenus();
        if (menus!=null){
            return Result.succ(menus);
        }
        return Result.fail("获取博客列表失败");
    }
    @RequestMapping("/submenus")
    public Result getSubMenus(){
        List<SubMenu> subMenus = menuMapper.getSubMenus();
        if (subMenus!=null){
            return Result.succ(subMenus);
        }
        return Result.fail("获取子列表失败");
    }
}
