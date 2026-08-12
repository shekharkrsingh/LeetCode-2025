class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
            int cnt = map.get(nums[i]);
            while (cnt > k) {
                if (nums[start] == nums[i]) {
                    cnt--;
                }
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}