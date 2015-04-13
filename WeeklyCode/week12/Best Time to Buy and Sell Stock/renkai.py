class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if len(prices) < 2 : return 0
        min = prices[0]; ret = 0
        for price in prices[1:]:
            if price - min > ret: ret = price - min
            if price < min: min = price
        return ret