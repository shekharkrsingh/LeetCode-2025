class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int a=0;
        int b=0;
        int c=0;

        for(int i=0;i<n;i++){
            int temp=Math.max(a,b)+nums[i];
            a=b;
            b=c;
            c=temp;
        }
        return Math.max(b,c);
    }
}