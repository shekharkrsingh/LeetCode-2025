class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] track = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                track[i] = 0;
                q.offer(i);
                if (!bfs(graph, q, visited, track)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, Queue<Integer> q, boolean[] visited, int[] track) {
        while (!q.isEmpty()) {
            int node = q.poll();
            int color = track[node];

            int[] adj = graph[node];

            for (int i : adj) {
                if (visited[i] && track[i] == color) {
                    return false;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    track[i] = color == 0 ? 1 : 0;
                    q.offer(i);
                }
            }
        }
        return true;
    }
}