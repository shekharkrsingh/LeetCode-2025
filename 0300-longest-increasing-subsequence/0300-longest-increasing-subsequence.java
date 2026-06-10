class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<n;i++){
            binarySearch(res, nums[i]);
        }
        return res.size();
    }

    private void binarySearch(List<Integer> res, int val){
        int n=res.size();
        int idx=n;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(res.get(mid)>=val){
                idx=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }

        }

        if(idx==n){
            res.add(val);
        }else{
            res.set(idx, val);
        }

    }
}