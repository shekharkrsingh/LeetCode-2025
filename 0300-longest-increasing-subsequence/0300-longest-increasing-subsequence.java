class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n + 1];
        for(int i=n-1; i>=0; i--){
            for(int j=i-1; j>=-1; j--){
                int take=0;
                if(j==-1 || nums[i]> nums[j]){
                    take=dp[i+1][ i+1]+1;
                }
                int notTake=dp[i+1][j+1];
                dp[i][j+1]=Math.max(take, notTake);
            }
        }

        return dp[0][0];
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