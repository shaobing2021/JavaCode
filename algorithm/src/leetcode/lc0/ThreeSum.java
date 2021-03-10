package leetcode.lc0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums==null||nums.length<=2) return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]>0) break;
            //去掉重复
            if (i>0&&nums[i]==nums[i-1]) continue;
            int left = i+1,right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if (sum==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left-1]) left++;
                    while (left<right&&nums[right]==nums[right+1]) right--;
                }else if (sum>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return lists;
    }
    public static List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int low = i+1;
            int high = nums.length-1;
            if (i>0&&nums[i]==nums[i-1]) continue;
            while (low<high){
                int sum = nums[i]+nums[low]+nums[high];
                ArrayList<Integer> list = new ArrayList<>();
                if (sum==0){
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
//                        if (!lists.contains(list)){
//                            lists.add(list);
//                        }
                    lists.add(list);
                    low++;
                    high--;
                    }
                else if(sum>0){
                    high--;
                }else {
                    low++;
                }
            }
        }
        return lists;
    }
}
