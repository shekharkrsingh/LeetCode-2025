class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxW = 0;
        int totalW = 0;
        for (int w : weights) {
            maxW = Math.max(w, maxW);
            totalW += w;
        }
        int start = maxW;
        int end = totalW;
        return binarySearch(weights, days, start, end);
    }

    private int binarySearch(int[] weights, int days, int start, int end) {
        int minC = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(weights, mid, days)) {
                minC = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minC;
    }

    private boolean isValid(int[] weights, int cap, int days) {
        int n = weights.length;
        int dayCnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weights[i];
            if (sum > cap) {
                dayCnt++;
                sum = weights[i];
            }
        }
        return dayCnt <= days;
    }
}