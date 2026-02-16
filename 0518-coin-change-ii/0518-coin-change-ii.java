class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp= new int[n][amount+1];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(n-1, amount, coins, n, dp);
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