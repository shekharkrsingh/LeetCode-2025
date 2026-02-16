class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);
        int lng = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            lng = Math.max(lng, dp[i]);
        }

        return lng;
    }

    private int sol(int i, int j, int n, int[] nums, int[][] dp) {
        if (i == n) {
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