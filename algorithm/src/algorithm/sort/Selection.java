package algorithm.sort;

import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        select(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void select(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[min]>arr[j]) min = j;
            }
            swap(arr,i,min);
        }
    }
    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
