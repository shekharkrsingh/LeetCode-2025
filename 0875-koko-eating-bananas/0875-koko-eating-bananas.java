class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MAX_VALUE;
        for (int banana : piles) {
            max = Math.max(banana, max);
        }
        int start = 1;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (piles[i] != 0) {
                    cnt += piles[i] / mid;
                    if (piles[i] % mid != 0) {
                        cnt++;
                    }
                }
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