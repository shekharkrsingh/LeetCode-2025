class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (n < (long) m * k)
            return -1;

        int minDay = bloomDay[0], maxDay = bloomDay[0];
        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int start = minDay, end = maxDay;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int flowers = 0, bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                    if (bouquets >= m)
                        return true; // early stop
                }
            } else {
                flowers = 0;
            }
        }

        return false;
    }
}