class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][4];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sol(0, 0, n, prices, dp);

    }

    private int sol(int i, int cnt, int n, int[] prices, int[][] dp) {
        if (cnt > 3 || i > n-1) {
            return 0;
        }

        if (dp[i][cnt] != -1) {
            return dp[i][cnt];
        }

        int profit= 0;

        if (cnt % 2 == 0) {
            profit = Math.max(profit, sol(i + 1, cnt + 1, n, prices, dp) - prices[i]);
        } else {
            profit = Math.max(profit, sol(i + 1, cnt + 1, n, prices, dp) + prices[i]);
        }
        profit = Math.max(profit, sol(i + 1, cnt, n, prices, dp));

        dp[i][cnt] = profit;
        return profit;
    }
}