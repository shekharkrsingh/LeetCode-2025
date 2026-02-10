class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1)
        return nums[0];
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 0; i < n-1; i++) {
            int temp = Math.max(a, b) + nums[i];
            a = b;
            b = c;
            c = temp;
        }

        int d=0;
        int e=0;
        int f=0;
        for(int i=1;i<n;i++){
            int temp= Math.max(d,e)+nums[i];
            d=e;
            e=f;
            f=temp;
        }
        return Math.max(Math.max(b,c), Math.max(e, f));
    }
}