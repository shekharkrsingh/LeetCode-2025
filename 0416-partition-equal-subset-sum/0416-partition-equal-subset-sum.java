class Solution {
    public boolean canPartition(int[] nums) {

        int n=nums.length;
        int sum=0;

        for(int i: nums){
            sum+=i;
        }
        if((sum%2)!=0){
            return false;
        }

        int target=sum/2;

        boolean[] curr= new boolean[target+1];
        boolean[] prev=new boolean[target+1];

        prev[0]=true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                curr[j]=prev[j];
                if(nums[i-1]<=j){
                    curr[j]= curr[j] || prev[j-nums[i-1]];
                }
            }

            for(int j=1;j<=target; j++){
                prev[j]=curr[j];
            }
        }

        return prev[target];
    }
}