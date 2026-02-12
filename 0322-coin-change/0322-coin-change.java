class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[] dp = new long[amount + 1];

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            long val = (int)Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    val = Math.min(dp[i - coins[j]], val);
                }
            }
            dp[i] = val+1;
        }

        if (dp[amount] >= Integer.MAX_VALUE)
            return -1;
        return (int) dp[amount];

    }

    private long sol(int amount, int n, int[] coins, long[] dp) {
        if (amount == 0) {
            return 0;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        long result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                result = Math.min(sol(amount - coins[i], n, coins, dp), result);
            }
        }

        dp[amount] = result + 1L;

        return dp[amount];

    }
}