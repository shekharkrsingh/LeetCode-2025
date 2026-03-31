class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int start = 0;
        int max = Integer.MIN_VALUE;
        boolean zCnt = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zCnt = true;
                max = Math.max(max, 0);
                max = Math.max(subArray(nums, n, start, i - 1), max);
                start = i + 1;
            }
        }
        if (start < n)
            max = Math.max(subArray(nums, n, start, n - 1), max);

        return max;

    }

    private int subArray(int[] nums, int n, int start, int end) {
        if (start >= end) {
            return nums[start];
        }

        int nCnt = 0;
        int mul = 1;
        for (int i = start; i <= end; i++) {
            mul *= nums[i];
            if (nums[i] < 0) {
                nCnt++;
            }
        }

        if (nCnt % 2 == 0) {
            return mul;
        }

        int val = mul;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            val /= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        max = val;
        val = mul;
        for (int i = end; i >= start; i--) {
            val /= nums[i];
            if (nums[i] < 0) {
                break;
            }
        }
        return Math.max(val, max);
    }
}