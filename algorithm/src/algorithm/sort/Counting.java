package algorithm.sort;

import java.util.Arrays;

public class Counting {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 8, 1, 3,3,6,3, 9, 0, 7};
        int[] result = counting(arr);
        System.out.println(Arrays.toString(result));
    }
    private static int[] counting(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
//        为什么是max-min+1，因为count数组只是用来记录个数的
        int[] count = new int[max-min+1];

        for (int num : arr) {
            count[num-min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] +=count[i-1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

//            arr[i]-min获取在count的索引，count[arr[i]-min]是获取在第多少个位置上，再-1即在
//            result的坐标
            result[count[arr[i]-min]-1]=arr[i];
//            为什么要--，因为如果有相同元素在同一个位置，在count对应索引值要--
            count[arr[i]-min]--;
        }
        return result;
    }
}
