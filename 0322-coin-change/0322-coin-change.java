class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[]dp = new int[amount+1];

        dp[0]=0;

        for(int i=1;i<=amount; i++){
            int min=100000;
            for(int j=0;j<n;j++){
                if(i-coins[j]>=0){
                    min=Math.min(min, dp[i-coins[j]]+1);
                }
            }
            dp[i]=min;
        }

        return dp[amount]>=100000?-1:dp[amount];

    }

    private int sol(int i, int[] coins, int[]dp){
        if(i==0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int min=100000;

        for(int j=0;j<coins.length;j++){
            if(i-coins[j]>=0){
                min=Math.min(min, sol(i-coins[j], coins, dp)+1);
            }
        }

        dp[i]=min;
        return min;
    }
}