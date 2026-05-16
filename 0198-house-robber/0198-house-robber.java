class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }
        int first=nums[0];
        int second=Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            int take = first + nums[i];
            int notTake = second;
            int temp = Math.max(take, notTake);
            first=second;
            second=temp;

        }

        return second;
    }

    private int sol(int n, int[] nums, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return nums[n];
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int take = sol(n - 2, nums, dp) + nums[n];
        int notTake = sol(n - 1, nums, dp);

        int max = Math.max(take, notTake);

        dp[n] = max;
        return max;

    }
}