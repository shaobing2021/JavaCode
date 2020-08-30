package algorithm.sort;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        insert(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void insert(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j]<arr[j-1]; j--) {
                    swap(arr,j,j-1);
            }
        }
    }
    public static void insert1(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }
    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
