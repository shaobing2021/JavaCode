package offer.lc6;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(2)));
    }
    public static double[] twoSum(int n){
        double[] res = new double[n*5+1];
        int[][] dp = new int[n+1][6*n+1];
        for (int i = 1; i <=6 ; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i*6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j-k<i-1){//为什么是i-1，因为最小也是i-1
                        break;
                    }
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        double total = Math.pow(6, n);
        for (int i = n; i <= 6*n; i++) {
            res[i-n] = dp[n][i]/total;
        }
        return res;
    }
}
