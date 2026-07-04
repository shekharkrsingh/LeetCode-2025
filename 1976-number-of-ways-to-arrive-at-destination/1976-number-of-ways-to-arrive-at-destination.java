class Solution {

    static final int MOD = 1_000_000_007;

    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj = adjacencyList(n, roads);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);
        int[] cnt = new int[n];
        dis[0] = 0;
        cnt[0] = 1;
        pq.offer(new long[] { 0, 0 });
        dijkstra(adj, pq, dis, cnt);
        return cnt[n - 1];
    }

    private void dijkstra(List<List<int[]>> adj, PriorityQueue<long[]> pq, long[] dis, int[] cnt) {

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long dist = cur[1];
            if (dist > dis[node])
                continue;
            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                long newDist = dist + edge[1];
                if (newDist < dis[next]) {
                    dis[next] = newDist;
                    cnt[next] = cnt[node];
                    pq.offer(new long[] { next, newDist });
                } else if (newDist == dis[next]) {
                    cnt[next] = (cnt[next] + cnt[node]) % MOD;
                }
            }
        }
    }

    private List<List<int[]>> adjacencyList(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[] { road[1], road[2] });
            adj.get(road[1]).add(new int[] { road[0], road[2] });
        }
        return adj;
    }
}