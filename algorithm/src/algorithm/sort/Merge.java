package algorithm.sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static int[] aux;
    private static void sort(int[] arr){
        aux = new int[arr.length];
//        对0-arr.leng-1进行排序
        sort(arr,0, arr.length-1);
    }
    private static void sort(int[] arr,int low,int high){
//        只剩一个元素就返回
        if(low>=high) return;
        int mid = low + (high-low)/2;
        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    private static void merge(int[] arr,int low ,int mid,int high){
//        保存[low,high]元素
        for (int i = low; i <= high; i++) {
            aux[i] = arr[i];
        }
        int m = mid+1;
        int l = low;
//        对[low,high]元素排序，注意边界
        for (int i = low; i <= high; i++) {
            //左边超出范围，则将右边的数填满到数组
            if (l>mid) arr[i] = aux[m++];
                //右边超出范围，则将左边的数填满到数组
            else if (m>high) arr[i] = aux[l++];
                //左边值大于右边，则右边数填到数组
            else if (aux[l]>aux[m]) arr[i] = aux[m++];
            //右边值大于左边，则左边数填到数组
            else arr[i] = aux[l++];
        }
    }

}
