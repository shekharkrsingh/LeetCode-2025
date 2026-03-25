class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] h = new long[n];
        long[] v = new long[m];

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
                v[j] += grid[i][j];
                totalSum += grid[i][j];
            }
            h[i] = sum;
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        long check = totalSum / 2;

        for (int i = 0; i < n; i++) {
            if (i != 0)
                h[i] += h[i - 1];
            if (h[i] == check)
                return true;
        }

        for (int i = 0; i < m; i++) {
            if (i != 0)
                v[i] += v[i - 1];
            if (v[i] == check)
                return true;
        }

        return false;
    }
}