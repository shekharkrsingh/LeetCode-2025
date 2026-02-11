class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        long[][] dp = new long[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return (int)sol(n-1, m-1, grid, dp);
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