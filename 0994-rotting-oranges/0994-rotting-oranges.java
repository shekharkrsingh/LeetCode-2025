class Solution {
    int[] idx1 = { -1, 1, 0, 0 };
    int[] idx2 = { 0, 0, -1, 1 };

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] track = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
            Arrays.fill(track[i], 0);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] { i, j });
                    visited[i][j] = true;
                }
            }
        }

        result = bfs(q, visited, grid, track, n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    private int bfs(Queue<int[]> q, boolean[][] visited, int[][] grid, int[][] track, int n, int m) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int i = node[0];
            int j = node[1];
            for (int k = 0; k < 4; k++) {
                if (i + idx1[k] < n && i + idx1[k] >= 0 && j + idx2[k] < m && j + idx2[k] >= 0 &&
                        grid[i + idx1[k]][j + idx2[k]] == 1 && !visited[i + idx1[k]][j + idx2[k]]) {
                    visited[i + idx1[k]][j + idx2[k]] = true;
                    track[i + idx1[k]][j + idx2[k]] = track[i][j] + 1;
                    grid[i + idx1[k]][j + idx2[k]] = -1;
                    q.offer(new int[] { i + idx1[k], j + idx2[k] });
                }
            }
        }

        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxCount = Math.max(maxCount, track[i][j]);
            }
        }
        return maxCount;
    }
}