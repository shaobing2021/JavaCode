package algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序是对插入排序的改进，其中h是每次的步长，
 */
public class Shell {
    public static void main(String[] args) {
        int[] arr = {2,5,8,1,3,9,0,7};
        shell(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 其实思路也算简单，h一般取
     * @param arr
     */
    public static void shell(int[] arr){
        int h = 1;
        //要记住这一行代码
        while (h<arr.length/3) h = 3*h+1;  //1 4 13 40 121
        while (h>=1){
            //h替换为1则是普通的插入排序算法
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j>=h&&arr[j]<arr[j-h]; j-=h) {
                    swap(arr,j,j-h);
                }
            }
            h = h/3;
        }

    }
    private static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
