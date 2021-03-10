package exam.ah;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 安恒信息笔试
 * 你要出去旅游N元住酒店，最少能住几万
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] prices = new int[strs.length-1];
        int money = 0 ;
        for (int i = 0; i < strs.length; i++) {
            if (i==strs.length-1){
                money = Integer.parseInt(strs[i]);
                break;
            }
            prices[i] = Integer.parseInt(strs[i]);
        }
//        System.out.println(Arrays.toString(prices));
//        System.out.println(money);
//        int[] prices = {1000,700,500};
//        int money = 1000;
        Arrays.sort(prices);
        help(prices,money,0);
    }
    private static int help(int[] prices,int money,int days){
        if (prices[0]>money) {
            System.out.println(-1);
            return -1;
        }
        for (int i = prices.length-1; i >=0; i--) {
            if (money-prices[i]==0){
                System.out.println(++days);
                return days;
            }else if (money-prices[i]>0){
                return help(prices, money - prices[i], ++days);
            }
        }
        return -1;
    }
}
