class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int maxPrice = prices[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxPrice = Math.max(prices[i], maxPrice);
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
        }
        return maxProfit;
    }
}