class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;
        for (int x : nums) {
            sum += x;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        Integer[][] dp = new Integer[n][2 * sum + 1];

        return sol(n - 1, target, nums, dp, sum);
    }

    private int sol(int i, int target, int[] nums,
            Integer[][] dp, int offset) {
        if (target > offset || target < -offset) {
            return 0;
        }
        if (i < 0) {
            return target == 0 ? 1 : 0;
        }

        if (dp[i][target + offset] != null) {
            return dp[i][target + offset];
        }

        int minus = sol(i - 1, target - nums[i], nums, dp, offset);

        int plus = sol(i - 1, target + nums[i], nums, dp, offset);

        dp[i][target + offset] = minus + plus;

        return dp[i][target + offset];
    }
}