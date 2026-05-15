class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        int min=n-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[min]>nums[mid]){
                min=mid;
            }
            if(nums[start]<=nums[mid]){
                if(nums[min]>nums[start]){
                    min=start;
                }
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        
        return nums[min];
    }
}