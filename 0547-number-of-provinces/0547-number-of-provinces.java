class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        int cnt = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && isConnected[i][j] == 1) {
                    cnt++;
                    visited[i][j] = true;
                    q.offer(new int[] { i, j });
                    bfs(isConnected, n, visited, q);
                }
            }
        }
        return cnt;
    }

    private void bfs(int[][] isConnected, int n, boolean[][] visited, Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];
            for (int k = 0; k < n; k++) {
                if (isConnected[i][k] == 1 && !visited[i][k]) {
                    visited[i][k] = true;
                    q.offer(new int[] { i, k });
                }
                if (isConnected[k][j] == 1 && !visited[k][j]) {
                    visited[k][j] = true;
                    q.offer(new int[] { k, j });
                }
            }
        }
    }
}