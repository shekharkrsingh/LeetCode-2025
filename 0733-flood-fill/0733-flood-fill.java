class Solution {
    private static final int[] x = {1, -1, 0, 0};
    private static final int[] y = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int stColor = image[sr][sc];

        if (stColor == color) {
            return image;
        }

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        image[sr][sc] = color;

        bfs(image, visited, q, color, stColor, n, m);

        return image;
    }

    private void bfs(int[][] image, boolean[][] visited,
                     Queue<int[]> q, int color,
                     int stColor, int n, int m) {

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node[0] + x[i];
                int ny = node[1] + y[i];

                if (isValid(nx, ny, n, m)
                        && !visited[nx][ny]
                        && image[nx][ny] == stColor) {

                    visited[nx][ny] = true;
                    image[nx][ny] = color;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    private boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}