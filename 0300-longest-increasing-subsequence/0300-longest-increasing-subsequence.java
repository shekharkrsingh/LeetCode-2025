class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(n-1, -1, nums, dp);
    }

    private int sol(int i, int j, int[] nums, int[][]dp){
        if(i<0){
            return 0;
        }

        if(dp[i][j+1]!=-1){
            return dp[i][j+1];
        }

        int count=0;

        
        if( j==-1 || nums[i]<nums[j]){
            count=sol(i-1, i, nums, dp)+1;
        }
        count=Math.max(count, sol(i-1, j, nums, dp));

        dp[i][j+1]=count;
        return count;
    }
}