package offer.lc6;

import java.util.ArrayList;

/**
 * 0 1 2 3 4
 * 0 1 3 4
 * 1 3 4
 * 1 3
 * 3
 */
public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(6,7));
    }
    //利用数学的方法
    public static int LastRemaining_Solution(int n, int m) {
        int res = 0;
        for (int i = 2; i <=n ; i++) {
            res = (res+m)%i;
        }
        return res;
    }
    //不考虑使用数学方法
    public static int LastRemaining_Solution1(int n, int m) {
        if (n<=0) return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //第m个数在n的哪个位置
        int c = (m-1)%n;
        while (list.size()>1){
             list.remove(c);
             c = (c+m-1)%list.size();
        }
        return list.get(0);
    }

}
