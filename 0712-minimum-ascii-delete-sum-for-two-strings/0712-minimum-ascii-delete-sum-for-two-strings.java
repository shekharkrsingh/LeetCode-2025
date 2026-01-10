class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubSequence(n - 1, m - 1, s1, s2, dp);

    }

    private int longestCommonSubSequence(int i, int j, String s1, String s2, int[][] dp) {
        int asciSum = 0;
        if (i < 0 || j < 0) {
            while (j >= 0) {
                asciSum += s2.charAt(j);
                j--;
            }
            while (i >= 0) {
                asciSum += s1.charAt(i);
                i--;
            }
            return asciSum;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int skip1 = 0;
        int skip2 = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = longestCommonSubSequence(i - 1, j - 1, s1, s2, dp);
        } else {
            skip1 = longestCommonSubSequence(i - 1, j, s1, s2, dp) + s1.charAt(i);
            skip2 = longestCommonSubSequence(i, j - 1, s1, s2, dp) + s2.charAt(j);

            dp[i][j] = Math.min(skip1, skip2);
        }
        return dp[i][j];
    }
}