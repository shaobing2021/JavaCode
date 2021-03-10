package offer.lc5;

import java.util.ArrayList;

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        System.out.println(findNumbersWithSum(arr, 21));
    }
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length-1;
        while (left<=array.length/2&&left<right){
            if ((array[left]+array[right])==sum){
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }else if (array[left]+array[right]>sum){
                right--;
            }else {
                left++;
            }
        }
        return list;
    }
}
