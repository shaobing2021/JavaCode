package offer.lc5;

import java.util.Arrays;

/**
 * 57-I双指针
 * 和为s的连续正序列
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,9)));
    }
    public static int[] twoSum(int[] nums,int target){
        int high = nums.length-1;
        int low = 0;
        while (low<high){
            if (nums[low]+nums[high]==target){
                return new int[]{nums[low],nums[high]};
            }
            if (nums[low]+nums[high]>target){
                high--;
            }else {
                low++;
            }
        }
        return new int[2];
    }
    public static int[] twoSum1(int[] nums,int target){
        int low = 0,high = nums.length-1;
        while (low<high){
            int temp = target-nums[low];
            if (temp>nums[high]){
                low++;
            }else if(temp<nums[high]){
                high--;
            }else {
                return new int[]{nums[low],nums[high]};
            }
        }
        return new int[0];
    }
}
