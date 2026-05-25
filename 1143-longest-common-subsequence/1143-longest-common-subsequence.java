class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n2;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                int cnt=0;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cnt=dp[i-1][j-1]+1;
                }else{
                    cnt=Math.max(dp[i-1][j], dp[i][j-1]);
                }

                dp[i][j]=cnt;
            }
        }

        return dp[n1][n2];
        
        
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