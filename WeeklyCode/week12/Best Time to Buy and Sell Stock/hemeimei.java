public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int max = 0,tempMax;
        int minBefore = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < minBefore){
                minBefore = prices[i];
            }else{
                tempMax = prices[i]-minBefore;
                if(max<tempMax){
                    max = tempMax;
                }
            }
        }
        return max;
    }
}