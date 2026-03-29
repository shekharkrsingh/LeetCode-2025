class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int el = -1;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                el = nums[i];
                cnt++;
                continue;
            }
            if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return el;
    }
}