package algorithm.sort;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }
//    冒泡排序
    private static void bubble(int[] arr){
        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < arr.length-j; i++) {
                if (arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
//    改进的冒泡
private static void bubble1(int[] arr){
    for (int j = 1; j < arr.length; j++) {
        boolean flag = true;
        for (int i = 0; i < arr.length-j; i++) {
            if (arr[i]>arr[i+1]){
                swap(arr,i,i+1);
                flag = false;
            }
        }
//        如果flag==true则说明，左边的数都小于右边的，则不必要在进行排序
        if (flag) break;
    }
}
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
