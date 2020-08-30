package com.shaobing.dao;

import com.shaobing.pojo.MainMenu;
import com.shaobing.pojo.SubMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<MainMenu> getMenus();
    List<SubMenu> getSubMenus();
}
