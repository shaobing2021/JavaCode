package exam.txy;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,1,3,4};
    }

    public int[] help(int[] arr){
        //1.hashmap
        //2.排序
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size()-1)!=arr[i]){
                list.add(arr[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j > arr.length-i-1; j++) {
                if (arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = arr[i];
                }
            }
        }
        return null;
    }
}
