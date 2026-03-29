class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sol(nums, k) - sol(nums, k - 1);
    }

    private int sol(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 0;
        int j = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                cnt++;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (cnt > k) {
                int val = map.get(nums[j]);
                if (val == 1) {
                    map.remove(nums[j]);
                    cnt--;
                } else {
                    map.put(nums[j], val - 1);
                }
                j++;
            }
            res += i - j + 1;
        }
        return res;
    }
}