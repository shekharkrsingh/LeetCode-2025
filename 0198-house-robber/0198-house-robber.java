class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return sol(n - 1, nums, dp);
    }

    private int sol(int idx, int[] nums, int[] dp) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        int take = sol(idx - 2, nums, dp) + nums[idx];
        int notTake = sol(idx - 1, nums, dp);

        dp[idx] = Math.max(take, notTake);

        return dp[idx];
    }
}