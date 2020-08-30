package com.shaobing.service;

import com.shaobing.pojo.ItemKill;

import java.util.List;

public interface IItemService {
    List<ItemKill> getKillItems();
    ItemKill getKillDetail(Integer id);
}
