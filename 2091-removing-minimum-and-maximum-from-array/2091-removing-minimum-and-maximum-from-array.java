class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = -1;
        int minVal = Integer.MAX_VALUE;
        int max = -1;
        int maxVal = Integer.MIN_VALUE;
        int res;

        for (int i = 0; i < n; i++) {
            if (minVal > nums[i]) {
                min = i;
                minVal = nums[i];
            }
            if (maxVal < nums[i]) {
                max = i;
                maxVal = nums[i];
            }
        }
        int maxOfMax = Math.max(min, max);
        int minOfMin = Math.min(min, max);
        min = minOfMin;
        max = maxOfMax;

        int minDis = Math.min(Math.max(min, max), n - 1 - Math.min(max, min));
        res = Math.min(min + n - max + 1, minDis + 1);

        return res;
    }
}