class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int maxInt = 1;
        int minInt=0;
        for (int i = 0; i < n; i++) {
            maxInt = Math.max(maxInt, nums[i]);
        }
        int start = 1;
        int end = maxInt;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            boolean valid = isValid(mid, nums, threshold);
            if (valid) {
                minInt = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minInt;

    }

    private boolean isValid(int mid, int[] nums, int threshold) {
        int n = nums.length;
        int th = 0;
        for (int num : nums) {
            th += num / mid;
            if (num % mid != 0) {
                th++;
            }
        }
        return th <= threshold;
    }

}