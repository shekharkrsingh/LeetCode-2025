import java.util.*;

class Solution {

    public int minCost(int n, int[][] edges) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        adjecency(edges, adj);

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];

            if (cost > dist[node]) continue;

            if (!adj.containsKey(node)) continue;

            for (int[] edge : adj.get(node)) {
                int next = edge[0];
                int w = edge[1];

                if (dist[next] > cost + w) {
                    dist[next] = cost + w;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }

    private void adjecency(int[][] edges, Map<Integer, List<int[]>> adj) {
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w * 2});
        }
    }
}
