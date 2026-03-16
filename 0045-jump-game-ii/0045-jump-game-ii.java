class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return sol(0, nums, n, dp);
    }

    private int sol(int idx, int[] nums, int n, int[] dp) {
        if (idx == n - 1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int jp = 100001;
        for (int i = 1; i <= nums[idx]; i++) {
            if(idx+i<n)
            jp = Math.min(sol(idx + i, nums, n, dp), jp);
        }
        dp[idx] = jp + 1;
        return dp[idx];

    }
}