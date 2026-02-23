class Solution {

    private static int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0, 0 };
    private static int[] dy = { 0, 1, -1, 0, 1, -1, 0, 1, -1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        boolean[][] visited = new boolean[n][n];
        int[][] dis = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            Arrays.fill(dis[i], -1);
        }

        dis[0][0] = 1;
        visited[0][0]=true;

        q.offer(new int[] { 0, 0 });

        bfs(q, grid, n, visited, dis);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

        return dis[n - 1][n - 1];
    }

    private void bfs(Queue<int[]> q, int[][] grid, int n, boolean[][] visited, int[][] dis) {
        while (!q.isEmpty()) {

            int[] node = q.poll();

            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 9; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    dis[nx][ny] = dis[x][y] + 1;

                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }
}