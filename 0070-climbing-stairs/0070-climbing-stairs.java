class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            int temp=a+b;
            a=b;
            b=temp;
        }
        return b;
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