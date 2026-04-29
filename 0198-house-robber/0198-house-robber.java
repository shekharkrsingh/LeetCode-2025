class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);
        dp[0]=nums[0];
        dp[1]=nums[1];
        for(int i=2;i<n;i++){
            int take=dp[i-2]+nums[i];
            int notTake=dp[i-1];

            dp[i]=Math.max(take, notTake);
        }

        return dp[n-1];

    }

    private int sol(int n, int[] nums, int[]dp){
        if(n<0) return 0;
        if(dp[n]!=-1)return dp[n];
        int take=sol(n-2, nums, dp)+nums[n];
        int notTake=sol(n-1, nums, dp);
        return dp[n]=Math.max(take, notTake);
    }
}