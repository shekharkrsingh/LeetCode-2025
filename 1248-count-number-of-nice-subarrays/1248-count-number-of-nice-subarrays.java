class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        if (k == 0) {
            return sol(nums, k);
        }
        return sol(nums, k) - sol(nums, k - 1);
    }

    private int sol(int[] nums, int k) {
        int n = nums.length;
        int start = 0;
        int cnt = 0;
        int oddCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                oddCnt++;
            }
            while (oddCnt > k) {
                if (nums[start] % 2 != 0) {
                    oddCnt--;
                }
                start++;
            }
            cnt += i - start + 1;
        }
        return cnt;
    }
}