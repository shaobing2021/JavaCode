package exam.jd;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println(m+" "+n);
        for (int i = m; i <= n; i++) {
            int temp = i;
            int k1 = temp%10;
            temp = temp/10;
            int k2 = temp%10;
            temp = temp/10;
            int k3 = temp%10;
            System.out.println(k1+" "+k2+" "+k3);
            if ((k1*k1*k1+k2*k2*k2+k3*k3*k3)==m){
                list.add(m);
            }
        }
        if (list.size()==0){
            System.out.println("no");
        }
        for (Integer integer : list) {
            System.out.println(integer+" ");
        }
    }
}
