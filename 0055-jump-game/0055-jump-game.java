class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int cnt=1;
        for(int i=0;i<n;i++){
            if(cnt==0){
                return false;
            }
            if(cnt<=nums[i]){
                cnt=nums[i];
                continue;
            }
            cnt--;
        }

        return true;
    }
}