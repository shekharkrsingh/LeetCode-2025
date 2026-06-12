class Solution {
    public int search(int[] nums, int target) {
        return searchElementInAnArray(nums, target);
    }

    private int searchElementInAnArray(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int index = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}