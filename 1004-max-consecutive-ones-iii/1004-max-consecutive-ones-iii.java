class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int maxLength = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                cnt++;
            }
            while (cnt > k) {
                if (nums[start] == 0) {
                    cnt--;
                }
                start++;
            }
            if (cnt <= k) {
                maxLength = Math.max(i - start + 1, maxLength);
            }
        }

        return maxLength;
    }
}