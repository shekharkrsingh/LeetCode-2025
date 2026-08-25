class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        int[] track = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] % k == 0 && nums[i]/k <=n) {
                track[(nums[i] / k) - 1]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (track[i] == 0) {
                return (i + 1) * k;
            }
        }
        return (n+1) * k;
    }
}