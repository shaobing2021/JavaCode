package offer.lc5;

import java.util.LinkedList;

/**
 * 维持单调队列
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
    public static int[] maxSlidingWindow(int[] nums,int k){
        if (nums==null||nums.length==0) return new int[0];
        int[] list = new int[nums.length-k+1];
        //实现单调递减队列
        LinkedList<Integer> lists = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!lists.isEmpty()&&lists.getLast()<nums[i]){
                lists.removeLast();
            }
            lists.addLast(nums[i]);
        }
        list[0] = lists.peekFirst();
        for (int i = k; i <nums.length ; i++) {
            if (lists.getFirst()==nums[i-k]){
                lists.removeFirst();
            }
            while(!lists.isEmpty()&&lists.getLast()<nums[i]){
                lists.removeLast();
            }
            lists.addLast(nums[i]);
            list[i-k+1] = lists.getFirst();
        }
        return list;
    }
}
