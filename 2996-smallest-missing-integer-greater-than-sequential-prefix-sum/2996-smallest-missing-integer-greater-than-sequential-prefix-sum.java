class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int pref = nums[0];
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i < n; i++) {
            if (i == n || nums[i] - 1 != nums[i - 1]) {
                while (set.contains(pref)) {
                    pref++;
                }
                return pref;
            }
            pref += nums[i];
        }
        if (n == 1)
            return ++pref;

        return pref;
    }
}