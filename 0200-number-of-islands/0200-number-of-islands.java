class Solution {
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, 1, -1 };

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    visited[i][j] = true;
                    q.offer(new int[] { i, j });
                    bfs(n, m, grid, visited, q);
                }
            }
        }

        return cnt;
    }

    private void bfs(int n, int m, char[][] grid, boolean[][] visited, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == '1' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}