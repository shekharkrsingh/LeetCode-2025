class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int lSum = 0;
        int rSum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        max = lSum;
        for (int i = 0; i < k; i++) {
            rSum += cardPoints[n - 1 - i];
            lSum -= cardPoints[k - i - 1];
            max = Math.max(max, lSum + rSum);
        }

        return max;
    }
}