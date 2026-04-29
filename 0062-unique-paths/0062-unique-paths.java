class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        dp[n-1][m-1]=1;
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        Arrays.fill(dp[0], 1);
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int total=0;
                total+=dp[i-1][j];
                total+=dp[i][j-1];
                dp[i][j]=total;
            }
        }

        return dp[n-1][m-1];
    }

    private int sol(int i, int j, int n, int m, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int total = 0;
        total += sol(i - 1, j, n, m, dp);
        total += sol(i, j - 1, n, m, dp);

        dp[i][j] = total;
        return total;
    }
}