class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sol(nums, goal) - sol(nums, goal - 1);
    }

    private int sol(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int n = nums.length;
        int j = 0;
        int cnt = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum > goal) {
                sum -= nums[j];
                j++;
            }
            cnt += i - j + 1;
        }
        return cnt;
    }
}