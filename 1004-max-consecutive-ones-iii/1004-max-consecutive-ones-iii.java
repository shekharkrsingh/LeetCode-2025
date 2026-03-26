class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = -1;
        int cnt = 0;
        int max = 0;

        while (i < n && j < n) {
            if (nums[i] == 0 && cnt < k) {
                cnt++;
            } else if (nums[i] == 0 && cnt == k) {
                max = Math.max(i - j-11, max);
                j++;
                while (nums[j] != 0)
                    j++;
            }
            max = Math.max(i - j, max);
            i++;
        }

        return max;
    }
}