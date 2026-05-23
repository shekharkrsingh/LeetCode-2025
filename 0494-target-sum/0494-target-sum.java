class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;

        return sol(n-1, target, nums);
    }

    private int sol(int i, int j, int[] nums){
        if(i<0 && j==0){
            return 1;
        }
        if(i<0 && j!=0){
            return 0;
        }

        // if(dp[i][j]!=0){
        //     return dp[i][j];
        // }

        int min=sol(i-1, j-nums[i], nums);
        int plus=sol(i-1, j+nums[i], nums);

        // dp[i][j]=min+plus;

        return min+plus;
    }
}