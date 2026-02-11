class Solution {
    public int uniquePaths(int n, int m) {
        int[] prev= new int[m];

        Arrays.fill(prev, 1);

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                prev[j]=prev[j-1]+ prev[j];
            }
        }

        return prev[m-1];
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