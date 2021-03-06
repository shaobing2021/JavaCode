package exam.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 全排列
 */
public class Main {
    public static void main(String[] args) {
        String str = "abcd";
        char[] chars = str.toCharArray();
        help(chars,0);
        System.out.println(list);
        System.out.println(list.size());
    }
    private static ArrayList<String> list = new ArrayList();
    private static void help(char[] chars,int k){
        if (k>=chars.length) {
            list.add(Arrays.toString(chars));
        }
        for (int i = k; i < chars.length; i++) {
            swap(chars,i,k);
            help(chars,k+1);
            swap(chars,i,k);
        }
    }
    private static void swap(char[] chars,int i,int k){
        char temp =chars[i];
        chars[i] = chars[k];
        chars[k] = temp;
    }
}
