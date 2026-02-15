class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int m=(2*k)+1;
        int[][] dp = new int[n + 1][m];

        int[] prev= new int[m];
        int[] curr= new int[m];

        for(int i=n-1;i>=0;i--){
            for( int j=m-2;j>=0;j--){
                int profit=0;
                if(j%2==0){
                    profit=Math.max(profit, prev[j+1]-prices[i]);
                }else{
                    profit=Math.max(profit, prev[j+1]+prices[i]);
                }

                profit=Math.max(profit, prev[j]);

                curr[j]=profit;
            }

            for(int j=0;j<m;j++){
                prev[j]=curr[j];
            }
        }

        return prev[0];
    }
}