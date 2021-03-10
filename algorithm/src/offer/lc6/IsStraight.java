package offer.lc6;

import java.util.Arrays;

/**
 * 61.从扑克牌中随机抽5张牌，判断是不是一个顺子，
 * 即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 */
public class IsStraight {
    public static void main(String[] args) {
        int[] numbers = {1,0,0,1,0};
        System.out.println(isContinuous(numbers));
    }
    public static boolean isContinuous(int [] numbers) {
        int joker = 0;
        if (numbers.length==0) return false;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i]==0) joker++;
            else if (numbers[i]==numbers[i+1]) return false;
        }
        return numbers[numbers.length-1]-numbers[joker]<5;
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        int i ;
        for (i = 0; i < nums.length-1; i++) {
            if (nums[i]==0){
                joker++;
            }else if (nums[i]==nums[i+1]){
                return false;
            }
        }
        return nums[nums.length-1]-nums[joker]<5;
    }

    public static boolean isContinuous1(int [] numbers) {
        if (numbers.length==0) return false;
        int temp = 0;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i]==0){
                temp++;
                continue;
            }
            if (i>1){
                int k ;
                if (i>0&&numbers[i]==numbers[i-1]){
                    return false;
                }
                if (i>0&&numbers[i-1]!=0&&(k=(numbers[i]-numbers[i-1]))>1){
                    temp-=(k-1);
                    if (temp<0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
