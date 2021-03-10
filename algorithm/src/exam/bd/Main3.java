package exam.bd;

import java.util.Scanner;

/**
 * 最多跨m个台阶，最少跨一个台阶
 * 每次台阶数各不相同，有多少不同走法
 */
public class Main3 {
    private static int i;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int max = scanner.nextInt();
        int[] temp = {0,0};
        if (total==1) System.out.println(1);
        count(total,max,temp);
        System.out.println(i);
    }
    private static void count(int total,int max,int[] temp){
        if (total==0) {
            i++;
            return;
        }
        if (total<0){
            return;
        }
        for (int j = 1; j <=max ; j++) {
            if (j!=temp[0]&&j!=temp[1]){
                int r =temp[0];
                int[] res = new int[2];
                res[0] = temp[1];
                res[1] = j;
                if (total-j<0){
                    break;
                }
                count(total-j,max,res);
            }
        }
    }
}
