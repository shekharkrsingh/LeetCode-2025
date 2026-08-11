class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        int sum = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                break;
            }
            sum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);

            if (num >= sum && num <= sum + n) {
                int index = num - sum;
                if (index < n) {
                    nums[index] = -Math.abs(nums[index]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return sum + i;
            }
        }

        return sum + n;
    }
}