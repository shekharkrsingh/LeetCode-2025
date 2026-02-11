class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp= new int[n][m];

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }

        for(int i=0;i<m;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){

                int up= dp[i-1][j];
                int down= dp[i][j-1];

                dp[i][j]=up+down;
            }
        }

        return dp[n-1][m-1];
    }

    private int sol(int i, int j, int n, int m, int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up=sol(i-1, j, n, m, dp);
        int down=sol(i, j-1, n, m, dp);

        dp[i][j]=up+down;

        return dp[i][j];
    }
}