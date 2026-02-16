class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = -1;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) >= nums[i]) {
                    idx = j;
                    break;
                }
            }
            if (idx != -1) {
                list.set(idx, nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        return list.size();
    }
}