class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (n < k)
            return -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (n == k) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        if (k == 1) {
            int max = -1;
            for (int i = 0; i < n; i++) {
                if (map.get(nums[i]) == 1) {
                    max = Math.max(max, nums[i]);
                }
            }

            return max;
        }

        int a = -1;
        int b = -1;
        if (map.get(nums[0]) == 1) {
            a = nums[0];
        }
        if (map.get(nums[n - 1]) == 1) {
            b = nums[n - 1];
        }
        return Math.max(a, b);

    }
}