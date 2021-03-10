package offer.lc6;

/**
 * 剑指offer63题
 */
public class MaxProfit {
    public static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice,prices[i]);
            profit = Math.max(profit,prices[i]-minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] s = {7,1,5,3,6,4};
        System.out.println(maxProfit(s));
    }
}
