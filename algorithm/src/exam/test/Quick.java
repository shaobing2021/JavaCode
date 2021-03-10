package exam.test;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void quick(int[] arrs,int low ,int high){
        if (low>=high) return;
        int mid = partion(arrs,low,high);
        quick(arrs,low,mid-1);
        quick(arrs,mid+1,high);
    }

    /**
     * 2 5 8 1 3 9 0 7 pivot 记录2
     * 0 5 8 1 3 9 0 7 第一遍遍历
     * 0 5 8 1 3 9 5 7
     * 0 1 8 1 3 9 5 7 第二遍遍历
     * 0 1 8 8 3 9 5 7
     * 0 1 2 8 3 9 5 7 最后一次
     */
    private static int partion(int[] arrs,int low,int high) {
        int pivot = arrs[low];
        while (low < high) {
            while (low < high && arrs[high] >= pivot) {--high;
            }
            arrs[low] = arrs[high];
            while (low < high && arrs[low] <= pivot) {++low;
            }
            arrs[high] = arrs[low];
        }
        arrs[low] = pivot;
        return low;
    }
}
