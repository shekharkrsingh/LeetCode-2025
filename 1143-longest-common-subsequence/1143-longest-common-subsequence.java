class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();

        int[] curr= new int[m+1];
        int[] prev= new int[m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int take=0;
                int left=0;
                int right=0;
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    take=prev[j-1]+1;
                }
                left=prev[j];
                right=curr[j-1];
                curr[j]=Math.max(take, Math.max(left, right));
            }

            for(int j=1;j<=m;j++){
                prev[j]=curr[j];
            }
        }

        return curr[m];
    }

    private int sol(int i, int j, String s1, String s2, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take = 0;
        int leftMove = 0;
        int rightMove = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            take = sol(i - 1, j - 1, s1, s2, dp) + 1;
        } else {
            leftMove = sol(i - 1, j, s1, s2, dp);
            rightMove = sol(i, j - 1, s1, s2, dp);
        }

        dp[i][j] = Math.max(take, Math.max(leftMove, rightMove));

        return dp[i][j];
    }
}