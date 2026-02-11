class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(m-1, n-1, m, n, dp);
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