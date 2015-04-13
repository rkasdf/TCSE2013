public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 ) return 0;
        int max = 0,minPri=prices[0], maxPri=prices[0];
        for(int i=1;i<prices.length;i++){
            int pri = prices[i];
            if(pri<maxPri){
                max+=maxPri-minPri;
                minPri = pri;
                maxPri = pri;
            }else{
                maxPri = pri;
            }
        }
        max+=maxPri-minPri;
        return max;
    }
}