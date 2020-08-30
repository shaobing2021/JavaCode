package com.shaobing.service;

import com.shaobing.dao.ItemKillSuccessMapper;
import com.shaobing.pojo.ItemKillSuccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

/**
 * 定时任务
 */
@Slf4j
@Service
public class SchedulerService {
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    private final Integer Expire_Order_Time = 30000;
    /**
     * 定时获取status=0的订单，并判断是否超过TTL，然后进行失效处理
     */
    @Scheduled(cron = "0/1 0/30 0/1 * * ? ")
    public void schdulerExpireOrders(){
        try{
            List<ItemKillSuccess> lists = itemKillSuccessMapper.selectExpireOrders();
            if (lists!=null&&!lists.isEmpty()){
                lists.stream().forEach(new Consumer<ItemKillSuccess>() {
                    @Override
                    public void accept(ItemKillSuccess itemKillSuccess) {
                        if (itemKillSuccess!=null&&itemKillSuccess.getStatus().intValue()==0
                                &&itemKillSuccess.getDiffTime()>Expire_Order_Time){
                            log.info("定时任务...清除该过期任务{}",itemKillSuccess);
                            itemKillSuccessMapper.expireOrder(itemKillSuccess.getCode());
                        }
                    }
                });
            }
        }catch (Exception e){
            log.info("定时获取订单并判断是否超过TTL值",e.fillInStackTrace());
        }
    }
}
