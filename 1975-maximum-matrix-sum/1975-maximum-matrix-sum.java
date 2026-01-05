class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int cnt = 0;
        int minVal = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < 0) {
                    cnt++;
                }
                int absVal = Math.abs(matrix[i][j]);
                minVal = Integer.min(minVal, absVal);
                sum += absVal;
            }
        }
        if (cnt % 2 != 0) {
            sum = sum - 2 * minVal;
        }
        return sum;
    }
}