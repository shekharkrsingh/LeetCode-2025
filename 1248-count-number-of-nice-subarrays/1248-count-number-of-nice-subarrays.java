class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return sol(nums, k)- sol(nums, k-1);
    }
    private int sol(int[] nums, int k){
        if(k<0){
            return 0;
        }
        int n=nums.length;
        int j=0;
        int res=0;
        int cnt=0;

        for(int i=0;i<n;i++){
            if(nums[i]%2!=0){
                cnt++;
            }
            while(cnt>k){
                if(nums[j]%2!=0){
                    cnt--;
                }
                j++;
            }
            res+=i-j+1;
        }

        return res;
    }
}