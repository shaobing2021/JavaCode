package com.shaobing.service.impl;

import com.shaobing.dao.ItemKillMapper;
import com.shaobing.pojo.ItemKill;
import com.shaobing.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService implements IItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemService.class);
    @Autowired
    private ItemKillMapper itemKillMapper;
    @Override
    public List<ItemKill> getKillItems() {
        return itemKillMapper.selectAll();
    }

    @Override
    public ItemKill getKillDetail(Integer id) {
        return itemKillMapper.selectById(id);
    }
}
