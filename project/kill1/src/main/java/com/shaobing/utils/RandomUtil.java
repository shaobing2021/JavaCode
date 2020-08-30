package com.shaobing.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数生成util
 * 通过时间戳+N位随机数生成订单编号
 * Date以及LocalDateTime格式化
 */
public class RandomUtil {
    private static final DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    public static String generateOrderCode(){
        return dataFormat.format(LocalDateTime.now())+generateNumber(6);
    }
    public static String generateNumber(final int num){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= num; i++) {
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(generateOrderCode());
        }
    }
}
