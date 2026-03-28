class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int j = 0;
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && cnt < k) {
                cnt++;
            } else if (nums[i] == 0 && cnt == k) {
                while (nums[j] != 0)
                    j++;
                j++;
            }

            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}