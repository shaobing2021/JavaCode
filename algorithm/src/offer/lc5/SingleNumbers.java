package offer.lc5;

import java.util.Arrays;

/**
 * 利用异或特性b^b=0  同时，异或特性不同的那位为1
 */
public class SingleNumbers {
    public static void main(String[] args) {
        int[] a={1,4,4,1,2,3};
        System.out.println(Arrays.toString(singleNumbers(a)));
    }
    public static int[] singleNumbers(int[] nums) {
        int a=0,b=0;
        int res=0;
        //获取a^b
        for (int num : nums) {
            res^=num;
        }
        int temp = 1;
        //获取可将ab分类的temp
        while ((temp&res)==0){
            temp<<=1;
        }
        for (int num : nums) {
            if ((num&temp)==0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
