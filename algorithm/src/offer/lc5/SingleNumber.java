package offer.lc5;

import javax.swing.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 整数的左移和右移
 * >>和>>>
 *
 */
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(2&1);
        System.out.println(3&1);
        System.out.println(4&1);
        int[] nums = {1,1,1,3,3,3,4,4,4,6};
        System.out.println(singleNumber1(nums));
    }
    /**
     * 烧脑写法，位运算写法
     * 使用一个32位的数组
     * 如果在32位的数组中，当其不被三整除则累加结果
     */
    public static int singleNumber1(int[] nums){
        int res=0;
        for (int j = 0; j < 32; j++) {
            int count =0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i]&(1<<j))!=0) count++;
            }
            if (count%3!=0) res+=(1<<j);
        }
        return res;
    }
    /**
     * 数学方法+set
     */
    public static int singleNumber2(int[] nums){
        long sum=0,count=0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            sum+=num;
        }
        for (Integer s : set) {
            count+=s;
        }
        return (int)((3*count-sum)/2);
    }
    /**
     * 采用java使用map常规写法
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        if (nums==null||nums.length<=2) return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
