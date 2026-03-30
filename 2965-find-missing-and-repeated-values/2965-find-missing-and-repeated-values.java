class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int N = n * m;

        long totalSum = (long) N * (N + 1) / 2;
        long totalSquareSum = (long) N * (N + 1) * (2 * N + 1) / 6;

        long gridSum = 0;
        long gridSquareSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gridSum += grid[i][j];
                gridSquareSum += (long) grid[i][j] * grid[i][j];
            }
        }

        long diff = totalSum - gridSum; 
        long sumMR = (totalSquareSum - gridSquareSum) / diff; 

        int missing = (int) ((diff + sumMR) / 2);
        int repeating = (int) (sumMR - missing);

        return new int[]{repeating, missing};
    }
}