package offer.lc6;

import java.util.Arrays;

/**
 * 构建乘积数组
 */
public class Construct {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(constructArr(a)));
    }

    public static int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        //遍历左边
        int left = 1;
        for (int i = 0; i < a.length; i++) {
            b[i] = left;
            left*=a[i];
        }
        int right = 1;
        for (int i = a.length-1;i>=0; i--) {
            b[i]*=right;
            right*=a[i];
        }
        return b;
    }

    /**
     * 超时
     * @param a
     * @return
     */
    public static int[] constructArr1(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int low = i-1;
            int high = i+1;
            b[i] = 1;
            while (low>=0){
                b[i]*=a[low];
                low--;
            }
            while (high<=a.length-1){
                b[i]*=a[high];
                high++;
            }
        }
        return b;
    }
    public static int[] constructArr2(int[] a) {
        int[] b = new int[a.length];
        int res = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i==j) continue;
                res*=a[j];
            }
            b[i] = res;
            res =1 ;
        }
        return b;
    }
}
