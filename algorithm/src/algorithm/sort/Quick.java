package algorithm.sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        sort(arr,0,arr.length-1);
    }
    public static void sort(int[] arr,int low,int high){
        if (low>=high) return;
        int mid = partition(arr, low, high);
        sort(arr,low,mid-1);
        sort(arr,mid+1,high);
    }
    public static int partition(int[] arr,int low ,int high){
        int l = low,h = high+1;
        while (true){
            while (arr[++l]<arr[low]) {
                if (l>=high) break;
            }
            while (arr[--h]>arr[low]){
                if (low>=h) break;
            }
            //实际上l大于等于就可以退出了
            if (l>=h) break;
            swap(arr,l,h);
        }
//        2 0 1 8 3 9 5 7   h在1  l在8 所以当然和1交换位置
        swap(arr,low,h);
        return h;
    }
    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
