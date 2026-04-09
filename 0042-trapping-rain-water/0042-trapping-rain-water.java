class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = n - 1;
        int water = 0;

        while (l <= r) {
            if (height[l] <= height[r]) {
                if (lMax > height[l]) {
                    water += lMax - height[l];
                }
                lMax = Math.max(lMax, height[l]);
                l++;
            } else {
                if (rMax > height[r]) {
                    water += rMax - height[r];
                }
                rMax = Math.max(rMax, height[r]);
                r--;
            }
        }

        return water;
    }
}