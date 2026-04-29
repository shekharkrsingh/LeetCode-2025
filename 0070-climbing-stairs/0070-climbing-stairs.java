class Solution {
    public int climbStairs(int n) {
        int first=1;
        int second=1;
        for(int i=2;i<=n;i++){
            int temp=first+second;
            first=second;
            second=temp;
        }
        return second;
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