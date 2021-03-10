package exam.daotong;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 给定数组a，找出不重复的三元组，三数之和为0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        int[] numbers = new int[strs.length];
        if (strs.length<3) return;
        for (int i = 0; i < strs.length; i++) {
            numbers[i] = Integer.valueOf(strs[i]);
        }

//        int[] strs = {-1,0,1,2,-1,4};
        help(numbers);
    }
    private static void help(int[] numbers){
        Arrays.sort(numbers);
        int[] res = {0,1};
        for (int i = 0; i < numbers.length - 2; i++) {
            int low = i+1;
            int high = numbers.length-1;
            while (low<high){
                if ((numbers[i]+numbers[low]+numbers[high])==0){
                    //-1 -1 0 1 2 4
                    if (numbers[i]!=res[0]||numbers[high]!=res[1]){
                        res[0] = numbers[i];
                        res[1] = numbers[high];
                        System.out.println(numbers[i]+" "+numbers[low]+" "+numbers[high]);
                    }
                    break;
                }else if ((numbers[i]+numbers[low]+numbers[high])>0){
                    high--;
                }else {
                    low++;
                }
            }
        }
    }
}
