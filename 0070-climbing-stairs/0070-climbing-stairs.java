class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return countWay(n, dp);
    }

    private int countWay(int n, int[] dp) {
        if (n == 1 || n == 2)
            return n;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = countWay(n - 1, dp) + countWay(n - 2, dp);
        return dp[n];
    }
}