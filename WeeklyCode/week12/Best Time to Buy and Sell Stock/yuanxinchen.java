class BestTimetoBuyandSellStockI {
  int buy = Integer.MIN_VALUE, sell = 0;
  for(int price : prices) {
      sell = Math.max(sell, buy + price);
      buy = Math.max(buy, -price);
  }
  return sell;
}

class BestTimetoBuyandSellStockII {
  public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE, res = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
			} else {
				res += prices[i] - min;
				min = prices[i];
			}
		}
		return res;
	}
}
