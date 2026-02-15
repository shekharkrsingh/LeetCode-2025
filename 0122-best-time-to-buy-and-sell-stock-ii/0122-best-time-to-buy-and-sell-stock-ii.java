class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int buy=prices[0];
        int cost=0;

        for(int i=1;i<n;i++){
            if(prices[i-1]>prices[i]){
                cost+=prices[i-1]-buy;
                buy=prices[i];
            }
        }

        cost+=prices[n-1]-buy;

        return cost;
    }
}