class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n-1; j >= -1; j--) {
                int take = 0;
                int notTake = dp[i + 1][j + 1];
                if (j == -1 || nums[i] > nums[j]) {
                    take = dp[i + 1][i + 1] + 1;
                }

                dp[i][j + 1] = Math.max(take, notTake);
            }
        }

        // for(int i=0;i<n+1; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[0][0];

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