class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n<m){
            return minDistance(word2, word1);
        }

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            prev[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            curr[0]=i;
            for (int j = 1; j <= m; j++) {
                int result = Integer.MAX_VALUE;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    result = prev[j - 1];
                } else {
                    result = Math.min(result, prev[j - 1] + 1);
                    result = Math.min(result, prev[j] + 1);
                    result = Math.min(result, curr[j - 1] + 1);
                }

                curr[j] = result;
            }
            for (int j = 0; j <= m; j++) {
                prev[j] = curr[j];
            }
        }

        return prev[m];
    }

    private int sol(int i, int j, String word1, String word2, int[][] dp) {

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
        } else {
            result = Math.min(result, sol(i - 1, j - 1, word1, word2, dp) + 1);
            result = Math.min(result, sol(i - 1, j, word1, word2, dp) + 1);
            result = Math.min(result, sol(i, j - 1, word1, word2, dp) + 1);
        }

        dp[i][j] = result;

        return result;
    }
}