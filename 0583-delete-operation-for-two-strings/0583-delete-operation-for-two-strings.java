class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int take = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    take = prev[j - 1] + 1;
                }

                curr[j] = Math.max(take, Math.max(curr[j - 1], prev[j]));
            }
            for (int j = 1; j <= m; j++) {
                prev[j] = curr[j];
            }
        }

        return n + m - 2 * prev[m];
    }
}