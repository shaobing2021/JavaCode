package offer.lc0;
import java.util.HashMap;
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(null,7,new int[3]));
    }
    //用set更好
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])==null){
                map.put(nums[i],1);
            }else {
                return nums[i];
            }
        }
        return -1;
    }
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i!=nums[i]){
                if (nums[i]==nums[nums[i]]) return nums[i];
                    swap(nums,i,nums[i]);
            }
        }
        return -1;
    }
    private static void swap(int[] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers==null||numbers.length==0) {
            duplication[0]=-1;
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            while (i!=numbers[i]){
                if (numbers[numbers[i]]==numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[numbers[i]];
                numbers[temp] = temp;
            }
        }
        return false;
    }
}
