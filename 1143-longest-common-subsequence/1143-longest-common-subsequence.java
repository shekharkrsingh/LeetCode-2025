class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(n-1, m-1, s1, s2, dp);
    }

    private int sol(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take=0;
        int leftMove=0;
        int rightMove=0;
        if(s1.charAt(i) == s2.charAt(j)){
            take=sol(i-1, j-1, s1, s2, dp)+1;
        }else{
            leftMove=sol(i-1, j, s1, s2, dp);
            rightMove=sol(i, j-1, s1, s2, dp);
        }

        dp[i][j]=Math.max(take, Math.max(leftMove, rightMove));

        return dp[i][j];
    }
}