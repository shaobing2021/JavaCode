package offer.lc5.lc0to5;

/**
 * 二分查找
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,9};
        int[] b = {0,1,3};
        System.out.println(missingNumber(a));
        System.out.println(missingNumber(b));
    }
    /*
    长度为1
    [0]  应该输出为1
    [1]  应该输出为0
    二分查找
     */
    public static int missingNumber(int[] nums) {
        int i = 0,j=nums.length-1;
        while (i<=j){
            int mid = i + (j-i)/2;
            if (mid==nums[mid]){
                i=++mid;
            }else {
                j=--mid;
            }
        }
        return i;
    }
}
