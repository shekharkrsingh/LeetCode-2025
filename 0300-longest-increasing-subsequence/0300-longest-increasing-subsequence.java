class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+1];

        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }

        arr[n]=Integer.MAX_VALUE;
        
        int[][] dp=new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], -1);
        }

        return sol(n-1, n, arr, dp);
    }

    private int sol(int i, int j, int[] nums, int[][]dp){
        if(i<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int count=0;

        
        if(nums[i]<nums[j]){
            count=sol(i-1, i, nums, dp)+1;
        }
        count=Math.max(count, sol(i-1, j, nums, dp));

        dp[i][j]=count;
        return count;
    }
}