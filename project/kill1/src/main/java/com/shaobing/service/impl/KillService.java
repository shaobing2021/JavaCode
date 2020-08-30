package com.shaobing.service.impl;

import com.shaobing.utils.RandomUtil;
import com.shaobing.dao.ItemKillMapper;
import com.shaobing.dao.ItemKillSuccessMapper;
import com.shaobing.enums.SysConstant;
import com.shaobing.pojo.ItemKill;
import com.shaobing.pojo.ItemKillSuccess;
import com.shaobing.service.IKillService;
import com.shaobing.service.RabbitSenderService;
import com.shaobing.utils.SnowFlake;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class KillService implements IKillService {
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;
    @Autowired
    private ItemKillMapper itemKillMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RabbitSenderService rabbitSenderService;

    //雪花算法用于生成唯一id
    private SnowFlake snowFlake=new SnowFlake(2,3);
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private CuratorFramework curatorFramework;
    private static final String pathPrefix = "/kill/zkLock/";
    //    使用zookeeper
    public Boolean killItemK2(Integer killId,Integer userId){
        Boolean result = false;
        final  String lockKey = new StringBuffer().append(killId).append(userId).append("-ZLock").toString();
        InterProcessMutex mutex = new InterProcessMutex(curatorFramework, pathPrefix + lockKey);
        try {
            if (mutex.acquire(10,TimeUnit.SECONDS)){
                if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
                    ItemKill itemKill = itemKillMapper.selectById(killId);
                    if (itemKill!=null&&1==itemKill.getCanKill()&&itemKill.getTotal()>0){
                        int res = itemKillMapper.updateKillItem(killId);
                        if (res>0){
                            commonRecordKillSuccessInfo(itemKill,userId);
                            result = true;
                        }
                    }
                }else {
                    log.info("该用户已经抢购过该商品");
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mutex!=null){
                try {
                    mutex.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
//    使用redisson
    public Boolean killItemK1(Integer killId,Integer userId){
        Boolean result = false;
        final  String lockKey = new StringBuffer().append(killId).append(userId).append("-RedisLock").toString();
        RLock lock = redissonClient.getLock(lockKey);
//            lock.lock(10,TimeUnit.SECONDS);
        try {
            boolean cacheRes = lock.tryLock(30, 10, TimeUnit.SECONDS);
            if (cacheRes) {
                if (itemKillSuccessMapper.countByKillUserId(killId, userId) <= 0) {
                    ItemKill itemKill = itemKillMapper.selectById(killId);
                    if (itemKill!=null&&1==itemKill.getCanKill()&&itemKill.getTotal()>0){
                        int res = itemKillMapper.updateKillItem(killId);
                        if (res>0){
                            commonRecordKillSuccessInfo(itemKill,userId);
                            result = true;
                        }
                    }
                }else {
                    log.info("该用户已经抢购过该商品");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
//     强制释放锁       lock.forceUnlock();
        }
        return result;
    }
    public Boolean killItem(Integer killId,Integer userId){
        Boolean result = false;
//        判断当前用户是否已经抢购过当前商品
        if (itemKillSuccessMapper.countByKillUserId(killId,userId)<=0){
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            final  String key = new StringBuffer().append(killId).append(userId).append("-RedisLock").toString();
            final String value = RandomUtil.generateOrderCode();
            Boolean cacheRes = operations.setIfAbsent(key,value);
            if (cacheRes){
                stringRedisTemplate.expire(key,30,TimeUnit.MINUTES);
                try{
                    //            查询待秒杀商品详情
                    ItemKill itemKill = itemKillMapper.selectById(killId);
//            判断是否可以被秒杀canKill=1？
                    if (itemKill!=null&&1==itemKill.getCanKill()&&itemKill.getTotal()>0){
//               扣减库存
                        int res = itemKillMapper.updateKillItem(killId);
//                扣减是否成功，生成秒杀成功的订单，同时通知用户
                        if (res>0){
                            commonRecordKillSuccessInfo(itemKill,userId);
                            result = true;
                        }
                    }
                }catch (Exception e){
                    log.info("加锁失败....用户id{}错误信息{}",userId,e.fillInStackTrace());
                }finally {
                    if (value.equals(operations.get(key))){
                        stringRedisTemplate.delete(key);
                    }
                }
            }
        }
        return result;
    }

    private void commonRecordKillSuccessInfo(ItemKill kill,Integer userId){
        ItemKillSuccess entity = new ItemKillSuccess();
        //这里可以使用雪花算法
//        String orderCode = RandomUtil.generateOrderCode();
        String orderCode = String.valueOf(snowFlake.nextId());
        entity.setCode(orderCode);
        entity.setItemId(kill.getItemId());
        entity.setKillId(kill.getId());
        entity.setUserId(userId.toString());
        entity.setStatus(SysConstant.OrderStatus.SuccessNotPayed.getCode().byteValue());
        entity.setCreateTime(LocalDateTime.now());
        //仿造单例模式双重检验锁
        if (itemKillSuccessMapper.countByKillUserId(kill.getId(),userId)<=0){
            //上面到下面也会出现问题，<=0的时候，进行插入
            int res =itemKillSuccessMapper.insert(entity);
            if (res>0){
                //发送异步邮件消息通知rabbitmq+email发送邮件
                rabbitSenderService.sendKillSuccesssEmailMsg(orderCode);
                //入死信队列，用于“失效”超过指定ttl时间让然未正常支付的订单
//                log.info("用户id{}",userId);
                rabbitSenderService.sendKillSuccessOrderExpireMsg(orderCode);
            }
        }
    }
}
