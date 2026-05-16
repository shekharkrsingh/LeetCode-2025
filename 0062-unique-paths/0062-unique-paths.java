class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                int up = 0;
                int left = 0;

                if (j - 1 >= 0) {
                    up = dp[i][j - 1];
                }
                if (i - 1 >= 0) {
                    left = dp[i - 1][j];
                }
                dp[i][j] = left + up;
            }
        }

        return dp[m - 1][n - 1];

    }

    private int sol(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        int up = 0;
        int left = 0;

        if (n - 1 >= 0) {
            up = sol(m, n - 1, dp);
        }
        if (m - 1 >= 0) {
            left = sol(m - 1, n, dp);
        }

        dp[m][n] = left + up;
        return dp[m][n];
    }
}