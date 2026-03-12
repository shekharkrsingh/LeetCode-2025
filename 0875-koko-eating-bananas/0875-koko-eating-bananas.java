class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int banana : piles) {
            max = Math.max(banana, max);
        }

        int start = 1;
        int end = max;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            long cnt = 0;
            for (int pile : piles) {
                cnt += (pile + mid - 1) / mid; 
            }

            if (cnt <= h) {
                max = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return max;
    }
}