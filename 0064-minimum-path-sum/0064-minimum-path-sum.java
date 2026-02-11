class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        int[][] dp = new int[n][m];
        int sum=0;

        for(int i=0;i<m;i++){
            sum+=grid[0][i];
            dp[0][i]=sum;
        }

        sum=0;

        for(int i=0;i<n;i++){
            sum+=grid[i][0];
            dp[i][0]=sum;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }

        return dp[n-1][m-1];
    }

    private long sol(int i, int j, int[][] grid, long[][]dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(i<0 || j<0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        long up=sol(i-1, j, grid, dp);
        long left= sol(i, j-1, grid, dp);

        dp[i][j]=Math.min(up, left)+(long)grid[i][j];

        return dp[i][j];
    }
}