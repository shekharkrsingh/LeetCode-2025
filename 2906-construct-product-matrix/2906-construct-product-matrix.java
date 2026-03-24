class Solution {
    private static final int CONST = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] res = new int[n][m];

        long product = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                res[i][j] = (int)product;
                product = (grid[i][j] * product) % CONST;
            }
        }
        product = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)(res[i][j] * product) % CONST;
                product = (product * grid[i][j]) % CONST;
            }
        }

        return res;
    }
}