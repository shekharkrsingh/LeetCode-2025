class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sol(0, -1, n, nums, dp);
    }

    private int sol(int i, int j, int n, int[] nums, int[][] dp) {
        if (i >= n) {
            return 0;
        }

        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        int take = 0;
        int notTake = sol(i + 1, j, n, nums, dp);
        if (j == -1 || nums[i] > nums[j]) {
            take = sol(i + 1, i, n, nums, dp) + 1;
        }

        dp[i][j + 1] = Math.max(take, notTake);

        return dp[i][j + 1];
    }
}