class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int noOfProv = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                noOfProv++;
                q.offer(i);
                visited[i] = true;
                bfs(isConnected, q, visited, n);
            }
        }

        return noOfProv;
    }

    private void bfs(int[][] isConnected, Queue<Integer> q, boolean[] visited, int n) {
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int i = 0; i < n; i++) {
                if (isConnected[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}