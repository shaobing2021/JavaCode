package com.shaobing.controller;

import com.shaobing.common.Result;
import com.shaobing.pojo.ItemKill;
import com.shaobing.service.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/item")
public class ItemConroller {
    private static final Logger log = LoggerFactory.getLogger(ItemConroller.class);

    @Autowired
    private IItemService itemService;
    /**
     * 获取待秒杀商品列表
     */
    @GetMapping("/list")
    public Result list(){
        try{
            List<ItemKill> killItems = itemService.getKillItems();
            return Result.succ(killItems);
        }catch (Exception e){
            log.error("获取待秒杀商品列表--发生异常：",e.fillInStackTrace());
        }
        return Result.fail("获取待秒杀商品异常");
    }
    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable Integer id){
        if (id==null||id<=0) return Result.fail("获取详情失败");
        ItemKill itemkill = itemService.getKillDetail(id);
        if (itemkill!=null){
            return Result.succ(itemkill);
        }
        return Result.fail("获取详情失败");
    }
}
