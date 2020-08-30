package com.shaobing.controller;

import com.shaobing.common.Result;
import com.shaobing.dao.ItemKillSuccessMapper;
import com.shaobing.dto.KillDto;
import com.shaobing.pojo.KillSuccessUserInfo;
import com.shaobing.service.IKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class KillController {
    private static final Logger log = LoggerFactory.getLogger(KillController.class);

    @Autowired
    private IKillService killService;
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    @PostMapping("/execute")
    public Result execute(@RequestBody KillDto killDto){
        if (killDto.getKillId()==null||killDto.getUserId()==null)
            return Result.fail("秒杀信息有误");
        Boolean result = killService.killItemK2(killDto.getKillId(), killDto.getUserId());
        if (result){
           return Result.succ("秒杀成功");
        }
        return Result.fail("商品抢购完毕或不在抢购时间段内");
    }
    @GetMapping("/killRecord/{orderNo}")
    public Result killRecordDetail(@PathVariable String orderNo){
        if (StringUtils.isEmpty(orderNo)) {
            return Result.fail("订单编号未空");
        }
        KillSuccessUserInfo killSuccessUserInfo = itemKillSuccessMapper.selectByCode(orderNo);
        if (itemKillSuccessMapper!=null){
            log.info("订单信息{}",killSuccessUserInfo);
            return Result.succ(killSuccessUserInfo);
        }
        return Result.fail("查找不到秒杀信息");
    }
}
