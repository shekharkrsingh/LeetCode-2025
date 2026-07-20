class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return traverseGrid(m - 1, n - 1, dp);
    }

    private int traverseGrid(int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int up = 0;
        int left = 0;
        if (i - 1 >= 0) {
            up = traverseGrid(i - 1, j, dp);
        }
        if (j - 1 >= 0) {
            left = traverseGrid(i, j - 1, dp);
        }

        dp[i][j] = up + left;
        return dp[i][j];
    }
}