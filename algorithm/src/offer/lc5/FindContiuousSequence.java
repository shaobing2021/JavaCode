package offer.lc5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 滑动窗口+采用数学方式
 * 难点：返回的是int[][] 核心ArrayList<int[]>存储数组，然后list.toArray(new int[list.size()])</>
 */
public class FindContiuousSequence {
    /**
     * 2.采用数学方式x+(x+1)+...+()
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> lists = new ArrayList();
        int n=2;
        target-=1;
        while (target>0){
            if (target%n==0){
                int[] temp = new int[n];
                for (int i = 0; i < n; i++) {
                    temp[i] = target/n+i;
                }
                lists.add(temp);
            }
            target-=n++;
        }
        Collections.reverse(lists);//翻转list
        return lists.toArray(new int[lists.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(findContinuousSequence(9)));
    }
    public static int[][] findContinuousSequence1(int target) {
        ArrayList<int[]> lists = new ArrayList<>();
        int count = 1;
        while (count<target/2){
            int num = target/++count;
            int[] temp = new int[count];
            if ((target-count+1)%count==0){
                for (int i = num; i < num+count; i++) {
                    temp[i-num]=i;
                }
                lists.add(temp);
            }

        }
        return lists.toArray(new int[0][]);
    }

    /**
     * 1.滑动窗口
     * @param target
     * @return
     */
    public static int[][] findContinuousSequence2(int target) {
        ArrayList<int[]> lists = new ArrayList<>();
        int l=1,r=2;
        while (l<r){
            int sum = (l+r)*(r-l+1)/2;
            if (sum==target){
                int[] t = new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    t[i-l] = i;
                }
                lists.add(t);
                l++;
            }else if (sum<target){
                r++;
            }else {
                l++;
            }
        }
        return lists.toArray(new int[lists.size()][]);
    }
}
