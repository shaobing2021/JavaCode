package offer.lc5.lc0to5;

/**
 * 二分法
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search1(nums,8));
        System.out.println(search1(nums,6));
    }
    public static int search1(int[] nums,int target){
        if (nums==null||nums.length==0) return 0;
        return help(nums,target)-help(nums,target-1);
    }
    public static int help(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            //返回的l为大于target的第一个数
            if (nums[mid]<=target){
                l=++mid;
            }else {
                r=--mid;
            }
        }
        return l;
    }
    /**
     * 一次遍历
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums,int target){
        if (nums==null||nums.length==0) return 0;
        int l=0,r=nums.length-1;
        while (l<=r){
            if (nums[l]==target&&nums[r]==target) break;
            if (nums[l]<target) l++;
            if (nums[r]>target) r--;
        }
        if (l>r) return 0;
        else return r-l+1;
    }
}
