class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < (long) m * k) {
            return -1;
        }
        int maxDay = 0;
        int minDay = bloomDay[0];
        for (int day : bloomDay) {
            maxDay = Math.max(maxDay, day);
            minDay = Math.min(minDay, day);
        }
        int start = minDay;
        int end = maxDay;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int cnt = 0;
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    total++;
                } else {
                    total = 0;
                }
                if (total == k) {
                    cnt++;
                    total = 0;
                }
            }
            if (cnt >= m) {
                maxDay = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return maxDay;
    }
}