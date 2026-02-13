class Solution {
    public int minInsertions(String s1) {
        int n = s1.length();
        StringBuilder s2 = new StringBuilder(s1);
        s2.reverse();
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int take = 0;
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    take = prev[j - 1] + 1;
                }
                curr[j] = Math.max(take, Math.max(curr[j - 1], prev[j]));
            }

            for (int j = 1; j <= n; j++) {
                prev[j] = curr[j];
            }
        }

        return n - curr[n];
    }
}