class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return dotProduct(n - 1, m - 1, nums1, nums2, dp);
    }

    private int dotProduct(int i, int j, int[] nums1, int[] nums2, int[][] dp) {
        if (i < 0 || j < 0) {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int dot = nums1[i] * nums2[j];
        int takeBoth = dot;
        int prev = dotProduct(i - 1, j - 1, nums1, nums2, dp);
        if (prev != Integer.MIN_VALUE) {
            takeBoth = Math.max(takeBoth, dot + prev);
        }
        int skip1 = dotProduct(i - 1, j, nums1, nums2, dp);
        int skip2 = dotProduct(i, j - 1, nums1, nums2, dp);
        dp[i][j] = Math.max(takeBoth, Math.max(skip1, skip2));
        return dp[i][j];
    }
}
