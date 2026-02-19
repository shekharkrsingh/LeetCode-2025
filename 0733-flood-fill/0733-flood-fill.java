class Solution {

    int[] idx1 = { -1, 1, 0, 0 };
    int[] idx2 = { 0, 0, -1, 1 };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { sr, sc });
        if (image[sr][sc] != color)
            bfs(image, color, image[sr][sc], q, n, m);
        return image;
    }

    private void bfs(int[][] image, int color, int start, Queue<int[]> q, int n, int m) {
        while (!q.isEmpty()) {
            int[] node = q.poll();

            int i = node[0];
            int j = node[1];

            image[i][j] = color;

            for (int k = 0; k < 4; k++) {
                if (i + idx1[k] >= 0 && i + idx1[k] < n && j + idx2[k] >= 0 && j + idx2[k] < m
                        && image[i + idx1[k]][j + idx2[k]] == start) {
                    image[i + idx1[k]][j + idx2[k]] = color;
                    q.offer(new int[] { i + idx1[k], j + idx2[k] });
                }
            }
        }
    }
}