class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sol(n - 1, m - 1, n - 1, m - 1, dp);
    }

    private int sol(int i, int j, int n, int m, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int total = 0;
        total += sol(i - 1, j, n, m, dp);
        total += sol(i, j - 1, n, m, dp);

        dp[i][j] = total;
        return total;
    }
}