class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0;
        int end = n - 1;
        int max = 0;
        while (start < end) {
            max = Math.max((end - start) * Math.min(height[start], height[end]), max);
            if (height[start] <= height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}