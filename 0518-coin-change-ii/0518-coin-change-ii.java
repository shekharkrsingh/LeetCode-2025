class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount + 1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount; j++){
                int take=0;
                if(j-coins[i-1]>=0){
                    take=dp[i][j-coins[i-1]];
                }
                int notTake=dp[i-1][j];
                dp[i][j]=take+notTake;
            }
        }

        return dp[n][amount];
    }

    private int countWay(int idx, int amount, int n, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][amount] != -1) {
            return dp[idx][amount];
        }

        int take = 0;
        if (amount - coins[idx] >= 0) {
            take = countWay(idx, amount - coins[idx], n, coins, dp);
        }
        int notTake = countWay(idx - 1, amount, n, coins, dp);

        dp[idx][amount] = take + notTake;
        return dp[idx][amount];
    }
}