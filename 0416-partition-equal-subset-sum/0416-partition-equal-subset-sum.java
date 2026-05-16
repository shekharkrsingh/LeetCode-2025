class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for( int val: nums){
            sum+=val;
        }

        if(sum%2!=0){
            return false;
        }
        int[][] dp =new int[n][(sum/2)+1];

        return sol(n-1, sum/2, nums, dp)==1;
    }

    private int sol(int i, int sum, int[] nums, int[][] dp){
        if(sum==0){
            return 1;
        }
        if(i<0){
            return -1;
        }

        if(dp[i][sum]!=0){
            return dp[i][sum];
        }

        int take=0;
        if(sum-nums[i]>=0){
            take=sol(i-1, sum-nums[i], nums, dp);
        }
        int notTake=sol(i-1, sum, nums, dp);

        dp[i][sum]=take==1|| notTake==1?1:-1;

        return dp[i][sum];
    }
}