class Solution {
    public int longestOnes(int[] nums, int k) {
        int arrLength = nums.length;
        int start=0;
        int bestLength=0;
        int zeroCnt=0;
        for(int i=0;i<arrLength;i++){
            if(nums[i]==0){
                zeroCnt++;
            }
            if(zeroCnt>k){
                if(nums[start]==0){
                    zeroCnt--;
                }
                start++;
            }

            bestLength=Math.max(bestLength, i-start+1);
        }

        return bestLength;

    }
}