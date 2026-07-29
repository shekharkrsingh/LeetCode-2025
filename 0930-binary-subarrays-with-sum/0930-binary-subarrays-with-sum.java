class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal==0){
            return subArray(nums, goal);
        }
        return subArray(nums, goal)-subArray(nums, goal-1);

    }

    private int subArray(int[] nums, int goal){
        int n=nums.length;
        int cnt=0;
        int start=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            while(sum>goal){
                sum-=nums[start];
                start++;
            }
            cnt+=i-start+1;
        }

        return cnt;
    }
}