class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (word1, word2) -> Integer.compare(word1.length(), word2.length()));

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sol(0, -1, n, words, dp);
    }

    private int sol(int i, int j, int n, String[] words, int[][] dp) {
        if (i == n) {
            return 0;
        }

        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }

        int take = 0;
        if (j == -1 || isPredecessor(words[i], words[j])) {
            take = sol(i + 1, i, n, words, dp) + 1;
        }
        int notTake = sol(i + 1, j, n, words, dp);

        dp[i][j + 1] = Math.max(take, notTake);

        return dp[i][j + 1];
    }

    private boolean isPredecessor(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n != m + 1) {
            return false;
        }
        boolean flag = false;

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 != n && idx2 != m) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                if (flag) {
                    return false;
                }
                flag = true;
                idx1++;
            } else {
                idx1++;
                idx2++;
            }
        }

        return true;
    }
}