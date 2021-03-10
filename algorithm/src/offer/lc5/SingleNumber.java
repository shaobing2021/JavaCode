package offer.lc5;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(2&1);
        System.out.println(3&1);
        System.out.println(4&1);
        int[] nums = {1,1,1,3,3,3,4,4,4,6};
        System.out.println(singleNumber(nums));
    }

    /**
     * 采用java常规写法
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            int c = map.getOrDefault(num, 0);
            map.put(num,c+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
