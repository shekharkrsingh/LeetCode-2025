class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        for (int i = 0; i < n; i++) {
            int end = m - 1;
            for (int j = m - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    end = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    boxGrid[i][end] = '#';
                    if (j != end)
                        boxGrid[i][j] = '.';
                    end--;
                }
            }
        }
        char[][] ans = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = boxGrid[i][j];
            }
        }

        return ans;
    }
}