class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findLISLength(0, -1, nums, dp);
    }

    private int findLISLength(int i, int j, int[] nums, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        int take = 0;
        if (j == -1 || nums[i] > nums[j]) {
            take = findLISLength(i + 1, i, nums, dp) + 1;
        }
        int notTake = findLISLength(i + 1, j, nums, dp);

        dp[i][j + 1] = Math.max(take, notTake);
        return dp[i][j + 1];
    }
}