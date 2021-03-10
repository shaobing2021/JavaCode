package exam.tx;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 出现次数前k多和前k少的字符串
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            if (map.get(s)==null){
                map.put(s,1);
            }else {
                map.put(s,map.get(s)+1);
            }
        }
        System.out.println(map);
    }
    private static void help(HashMap<String,Integer> map,int k){
        String[] strs = new String[k];

    }
}
