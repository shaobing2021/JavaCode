package exam.sm;

/**
 * 赛码题目
 */

import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] arr = new int[a];
            int[] brr = new int[b];
            for(int i = 0 ;i<a;i++){
                arr[i] = sc.nextInt();
            }
            for(int i = 0 ;i<b;i++){
                brr[i] = sc.nextInt();
            }
            int i = 0;
            int j = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(i!=arr.length&&j!=brr.length){
                if(arr[i]>brr[j]){
                    list.add(brr[j++]);
                }else if(arr[i]<brr[j]){
                    list.add(arr[i++]);
                }else{
                    list.add(arr[i++]);
                    j++;
                }
            }
            while(i<=arr.length-1){
                list.add(arr[i++]);
            }
            while(j<=brr.length-1){
                list.add(brr[j++]);
            }
            for(int k = 0;k<list.size();k++){
                if(k==list.size()-1){
                    System.out.println(list.get(k));
                    break;
                }
                System.out.print(list.get(k)+" ");
            }
        }
    }
}