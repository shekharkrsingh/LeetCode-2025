class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sol(n - 1, m - 1, word1, word2, dp);
    }

    private int sol(int i, int j, String word1, String word2, int[][] dp) {

        if (i < 0 && j < 0) {
            return 0;
        }

        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int result = Integer.MAX_VALUE;

        if (word1.charAt(i) == word2.charAt(j)) {
            result = sol(i - 1, j - 1, word1, word2, dp);
        }
        result = Math.min(result, sol(i - 1, j - 1, word1, word2, dp) + 1);
        result = Math.min(result, sol(i - 1, j, word1, word2, dp) + 1);
        result = Math.min(result, sol(i, j-1, word1, word2, dp) + 1);

        dp[i][j] = result;

        return result;
    }
}