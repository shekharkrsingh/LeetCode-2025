class Solution {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[length - 1] != nums[length - 2]) {
            return nums[length - 1];
        }
        int start = 1;
        int end = length - 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid + 1] != nums[mid] && nums[mid - 1] != nums[mid]) {
                return nums[mid];
            }

            if (mid % 2 != 0) {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid + 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}