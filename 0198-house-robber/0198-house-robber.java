class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n+1];
        Arrays.fill(dp, -1);

        return sol(n-1, nums, dp);
    }

    private int sol(int n, int[] nums, int[]dp){
        if(n<0) return 0;

        if(dp[n]!=-1){
            return dp[n];
        }

        int take=sol(n-2, nums, dp)+nums[n];
        int notTake=sol(n-1, nums, dp);

  

        return dp[n]=Math.max(take, notTake);
    }
}