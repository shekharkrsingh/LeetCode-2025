class Solution {

    private static int[] idx1 = { -1, 1, 0, 0 };
    private static int[] idx2 = { 0, 0, -1, 1 };

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        int[][] dis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                visited[i][j] = false;
                dis[i][j] = 0;

                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j, 0 });
                    visited[i][j] = true;
                }
            }
        }

        bfs(n, m, mat, q, visited, dis);

        return dis;

    }

    private void bfs(int n, int m, int[][] mat, Queue<int[]> q, boolean[][] visited, int[][] dis) {

        while (!q.isEmpty()) {

            int[] node = q.poll();

            int i = node[0];
            int j = node[1];
            int distance = node[2];

            for (int k = 0; k < 4; k++) {

                int newI = i + idx1[k];
                int newJ = j + idx2[k];
                int newD = distance + 1;

                if (isValid(i, j, k, n, m) && mat[newI][newJ] == 1 && !visited[newI][newJ]) {
                    visited[newI][newJ] = true;
                    dis[newI][newJ] = newD;
                    q.offer(new int[] { newI, newJ, newD });

                }
            }

        }
    }

    private boolean isValid(int i, int j, int k, int n, int m) {
        if (i + idx1[k] < 0 || i + idx1[k] >= n || j + idx2[k] < 0 || j + idx2[k] >= m) {
            return false;
        } else {
            return true;
        }
    }
}