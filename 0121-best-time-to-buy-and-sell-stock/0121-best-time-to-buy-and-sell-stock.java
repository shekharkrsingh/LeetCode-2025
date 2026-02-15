class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxVal = prices[n - 1];
        int profit = 0;
        for (int i = n - 2; i >= 0; i--) {
            profit = Math.max(profit, maxVal - prices[i]);
            maxVal = Math.max(maxVal, prices[i]);
        }

        return profit;
        // int n=prices.length;
        // int buy=prices[0];
        // int cost=0;
        // for(int i=1;i<n;i++){
        //     if(prices[i-1]>prices[i]){
        //         cost+=prices[i-1]-buy;
        //         buy=prices[i];
        //     }
        // }

        // return cost
    }
}