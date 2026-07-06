class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int min = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[start] <= nums[mid]) {
                min = Math.min(nums[start], min);
                start = mid + 1;
            } else {
                min = Math.min(nums[mid], min);
                end = mid - 1;
            }
        }

        return min;
    }
}