class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int lMax = 0;
        int rMax = 0;
        int water = 0;

        while (l <= r) {
            if (height[l] <= height[r]) {
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
                r--;
            }
        }

        return water;
    }
}