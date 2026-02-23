class Solution {

    private static int MAX = 1000000;
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] effort = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        for (int i = 0; i < n; i++) {
            Arrays.fill(effort[i], MAX);
        }

        effort[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0 });

        dij(pq, heights, effort, n, m);

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(effort[i]));
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(heights[i]));
        }



        return effort[n - 1][m - 1];
    }

    private void dij(PriorityQueue<int[]> pq, int[][] heights, int[][] efforts, int n, int m) {
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            int e = node[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int ne = Math.max(Math.abs(heights[x][y] - heights[nx][ny]), e);
                    if (efforts[nx][ny] > ne) {
                        pq.offer(new int[] { nx, ny, ne });
                        efforts[nx][ny] = ne;
                    }
                }
            }
        }
    }
}