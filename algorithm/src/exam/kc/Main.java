package exam.kc;

import java.util.Scanner;

/**
 * 科创信息
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        if (l>Integer.MAX_VALUE||l<Integer.MIN_VALUE){
            System.out.println("error");
            return;
        }
        long temp = l;
        long res=0;
        while (l>0){
            long a = l%10;
            l = l/10;
            res= res*10+a;
        }
        if (res==temp){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
