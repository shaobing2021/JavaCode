package exam.tx;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定两个排序号的链表，求公共子序列
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        long[] a1 = new long[s1];
        for (int i = 0; i < s1; i++) {
            a1[i] = sc.nextInt();
        }
        int s2 = sc.nextInt();
        long[] a2 = new long[s2];
        for (int i = 0; i < s2; i++) {
            a2[i] = sc.nextInt();
        }
//        int[] a1={6,5,4,3,2,1};
//        int[] a2={6,5,3,2,1};
        help(a1,a2);
    }
    private static void help(long[] a1,long[] a2){
        ArrayList<Long> list = new ArrayList<>();
        int t1=0,t2=0;
        while (t1<a1.length&&t2<a2.length){
            if (a1[t1]>a2[t2]){
                t1++;
            }else if (a1[t1]<a2[t2]){
                t2++;
            }else {
                list.add(a1[t1]);
                t1++;
                t2++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
