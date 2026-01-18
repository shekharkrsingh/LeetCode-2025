import java.util.*;
class Solution {
    boolean ok(int[][] g, long[][] rs, long[][] cs, long[][] d1, long[][] d2, int k) {
        int m = g.length, n = g[0].length;
        for (int r = 0; r <= m - k; r++) {
            for (int c = 0; c <= n - k; c++) {
                long tgt = rs[r][c + k] - rs[r][c];
                boolean f = true;
                for (int i = 0; f && i < k; i++) {
                    long a = rs[r + i][c + k] - rs[r + i][c];
                    long b = cs[r + k][c + i] - cs[r][c + i];
                    f = a == tgt && b == tgt;
                }
                if (!f) continue;
                long x = d1[r + k][c + k] - d1[r][c];
                long y = d2[r + k][c] - d2[r][c + k];
                if (x == tgt && y == tgt) return true;
            }
        }
        return false;
    }

    public int largestMagicSquare(int[][] g) {
        int m = g.length, n = g[0].length;
        long[][] rs = new long[m][n + 1];
        long[][] cs = new long[m + 1][n];
        long[][] d1 = new long[m + 1][n + 1];
        long[][] d2 = new long[m + 1][n + 1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                rs[i][j + 1] = rs[i][j] + g[i][j];
                cs[i + 1][j] = cs[i][j] + g[i][j];
                d1[i + 1][j + 1] = d1[i][j] + g[i][j];
            }

        for (int i = 0; i < m; i++)
            for (int j = n - 1; j >= 0; j--)
                d2[i + 1][j] = d2[i][j + 1] + g[i][j];

        for (int k = Math.min(m, n); k > 1; k--)
            if (ok(g, rs, cs, d1, d2, k)) return k;

        return 1;
    }
}