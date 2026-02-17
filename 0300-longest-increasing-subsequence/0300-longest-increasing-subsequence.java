class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxVal = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int take = 0;
                if (nums[j] < nums[i]) {
                    take = dp[j] + 1;
                }
                dp[i] = Math.max(take, dp[i]);
                maxVal = Math.max(maxVal, dp[i]);
            }
        }

        return maxVal;
    }
}