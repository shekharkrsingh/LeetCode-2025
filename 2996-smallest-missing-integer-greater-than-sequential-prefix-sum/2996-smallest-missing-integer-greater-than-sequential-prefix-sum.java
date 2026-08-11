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

        for (int x = sum; x <= sum + n; x++) {
            boolean found = false;

            for (int num : nums) {
                if (num == x) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return x;
            }
        }

        return sum + n + 1;
    }
}