class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int lb = binarySearchLB(matrix, n, m, target, 0, n - 1);
        if(lb==n){
            return false;
        }
        return binarySearch(matrix, lb, m, target, 0, m);
    }

    private int binarySearchLB(int[][] matrix, int n, int m, int target, int start, int end) {
        int lb = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][m - 1] >= target) {
                lb = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return lb;
    }

    private boolean binarySearch(int[][] matrix, int n, int m, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[n][mid] == target) {
                return true;
            }
            if (matrix[n][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}