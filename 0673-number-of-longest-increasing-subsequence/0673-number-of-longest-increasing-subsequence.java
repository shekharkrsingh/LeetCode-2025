class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] track = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(track, 1);

        int maxVal = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int take = 0;
                if (nums[j] < nums[i]) {
                    take = dp[j] + 1;
                }
                int notTake = dp[i];
                if (take > notTake) {
                    track[i] = track[j];
                }
                if (take == notTake) {
                    track[i] += track[j];
                }
                dp[i] = Math.max(take, notTake);
                maxVal = Math.max(dp[i], maxVal);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == maxVal) {
                count += track[i];
            }
        }

        System.out.println(Arrays.toString(track));
        System.out.println(Arrays.toString(dp));
        return count;
    }
}