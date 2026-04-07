class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int max = 0;
        int[] pre = new int[n];
        int[] post = new int[n];
        int water = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            pre[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            post[i] = max;
        }

        for (int i = 0; i < n; i++) {
            water += Math.min(pre[i], post[i]) - height[i];
        }

        return water;
    }
}