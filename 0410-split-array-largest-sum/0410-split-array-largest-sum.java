class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int end = 0;
        for (int num : nums) {
            end += num;
        }
        return binarySearch(nums, k, start, end);

    }

    private int binarySearch(int[] nums, int k, int start, int end) {
        int min = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, k, mid)) {
                end = mid - 1;
                min = mid;
            } else {
                start = mid + 1;
            }
        }
        return min;
    }

    private boolean isValid(int[] nums, int k, int mid) {
        int n = nums.length;
        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>mid){
                return false;
            }
            if (sum + nums[i] > mid) {
                sum = nums[i];
                cnt++;
            } else {
                sum += nums[i];
            }
        }
        return cnt <= k;

    }
}