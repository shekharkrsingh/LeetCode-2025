class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        long[] dp= new long[amount+1];

        Arrays.fill(dp, -1);

        long numCoins=sol(amount, n, coins, dp);

        if(numCoins>=Integer.MAX_VALUE){
            return -1;
        }
        return (int)numCoins;

    }

    private long sol(int amount, int n, int[] coins, long[] dp){
        if(amount==0){
            return 0;
        }

        if(dp[amount]!=-1){
            return dp[amount];
        }

        long result=Integer.MAX_VALUE;

        for(int i=0;i<n ;i++){
            if(coins[i]<=amount){
                result= Math.min(sol(amount-coins[i], n, coins, dp), result);
            }
        }

        dp[amount]=result+1L;

        return dp[amount];

    }
}