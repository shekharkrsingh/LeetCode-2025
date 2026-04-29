class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return sol(n, dp);
    }

    private int sol(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = sol(n - 1, dp) + sol(n - 2, dp);
        return dp[n];
    }
}