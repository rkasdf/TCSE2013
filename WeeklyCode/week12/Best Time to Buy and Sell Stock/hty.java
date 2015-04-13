public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tem = prices[i] - prices[i - 1];
            if (tem > 0)
                profit += tem;
        }
        return profit;
    }
}