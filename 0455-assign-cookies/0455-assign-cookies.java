class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int idx1 = 0;
        int idx2 = 0;

        int cnt = 0;

        while (idx1 < n && idx2 < m) {
            if (g[idx1] <= s[idx2]) {
                cnt++;
                idx1++;
                idx2++;
            } else {
                if (g[idx1] > s[idx2]) {
                    idx2++;
                }
            }
        }

        return cnt;
    }
}