package exam.bd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 百度编程题
 * n张卡片，要么是0要么是5，从中选出若干卡片组成一些数字，能够整除90%
 * 不存在则输出-1
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int r5 = 0,r0=0;
        for (int i = 0; i < total; i++) {
            if (scanner.nextInt()==5){
                r5++;
            }else {
                r0++;
            }
        }
        ArrayList<Object> list = new ArrayList<>();
        if (r0==0||r5<9){
            System.out.println(-1);
            return;
        }
        r5= r5/9;
        for (int i = 0; i < r5; i++) {
            
        }
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
    }
}
/*
5 5 0 0
5 0 5 0
5 0 0 5
5 5 5 0 0
5 5 0 5 0
5 5 0 0 5
5 0 5 5 0
5 0 5 0 5
5 0 0 5 5
  5 5 5 0


 */