class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp= new int[n+1][amount+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                int count=0;
                if(coins[i-1]<=j){
                    count+=dp[i][j-coins[i-1]];
                }
                count+=dp[i-1][j];
                dp[i][j]=count;
            }
        }

        return dp[n][amount];
    }

    private int sol(int i, int amount, int[] coins, int n, int[][] dp){
        if(amount==0){
            return 1;
        }

        if(i<0){
            return 0;
        }

        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int count=0;

        if(coins[i]<=amount)
        count+= sol(i, amount-coins[i], coins, n, dp);
        count+=sol(i-1, amount, coins, n, dp);

        dp[i][amount]=count;

        return count;
    }
}