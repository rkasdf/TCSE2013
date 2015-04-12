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
		int buy = Integer.MAX_VALUE, sell = 0;
		for(int price : prices) {
			if(price > buy) sell += price - buy;
			buy = price;
		}
		return sell;
	}
}
