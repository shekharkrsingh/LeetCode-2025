class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(n1-1, n2-1, text1, text2, dp);
        
    }

    private int sol(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int cnt = 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            cnt = sol(i - 1, j - 1, s1, s2, dp) + 1;
        } else {
            cnt = Math.max(sol(i - 1, j, s1, s2, dp), sol(i, j - 1, s1, s2, dp));
        }

        dp[i][j] = cnt;

        return cnt;

    }
}