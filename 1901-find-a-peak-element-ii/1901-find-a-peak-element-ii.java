class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0;
        int high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int maxIdx = findHeigh(n, mid, mat);

            int left = mid - 1 >= 0 ? mat[maxIdx][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxIdx][mid + 1] : -1;

            int curr = mat[maxIdx][mid];

            if (left < curr && right < curr) {
                return new int[] { maxIdx, mid };
            } else if (left > curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { -1, -1 };
    }

    private int findHeigh(int n, int m, int[][] mat) {
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (mat[i][m] > mat[idx][m]) {
                idx = i;
            }
        }
        return idx;
    }
}