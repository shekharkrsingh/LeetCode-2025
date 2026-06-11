class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarrysWithMaxKOdd(nums, k) - numberOfSubarrysWithMaxKOdd(nums, k - 1);
    }

    private int numberOfSubarrysWithMaxKOdd(int[] nums, int k) {
        if (k < 0 || nums == null) {
            return 0;
        }
        int length = nums.length;
        int oddCount = 0;
        int start = 0;
        int totalSubarryWithKOdd = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }
            totalSubarryWithKOdd += i - start + 1;
        }

        return totalSubarryWithKOdd;
    }
}