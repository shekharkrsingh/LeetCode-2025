class Solution {

    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    
                    visited[i][j] = true;
                    q.offer(new int[] { i, j });
                }
            }
        }

        bfs(n, m, board, q, visited);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(int n, int m, char[][] board, Queue<int[]> q, boolean[][] visited) {
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int x = node[0];
            int y = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 'O' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }

}