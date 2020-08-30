package exam.jd;

import java.util.Scanner;

/**
 * 自从学了素数以后，小明喜欢上了数字2、3和5。当然，如果一个数字里面只出现2、3和5这三个数字，他也一样喜欢，例如222、2355、223355。
 * 现在他希望你能够帮他编写一个程序，快速计算出由2、3、5这三个数字组成的由小到大的第n个数，当然也包括2、3和5
 * 输入描述
 * 单组输入。
 * 每组输入数据占1行，每行输入一个正整数n。（n<=1000）
 * 输出描述
 * 每组输出数据占1行，即满足要求的第n个数。
 */
public class Solution1 {
    public static void main(String[] args) {
        while (true){
            int i = 0;
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            count(sb,i,m);
        }

    }
    private static void count(StringBuilder sb,int i,int m){
        if (i>m) return;
        StringBuilder temp = new StringBuilder(sb);
        sb.append("2");
        if (++i==m){
            System.out.println(Integer.valueOf(sb.toString()));
            return ;
        }
        count(sb,i*3,m);
        sb = new StringBuilder(temp);
        sb.append("3");
        if (++i==m){
            System.out.println(Integer.valueOf(sb.toString()));
            return ;
        }
        count(sb,i*3,m);
        sb = new StringBuilder(temp);

        sb.append("5");
        if (++i==m){
            System.out.println(Integer.valueOf(sb.toString()));
            return ;
        }
        count(sb,i*3,m);
    }
}
