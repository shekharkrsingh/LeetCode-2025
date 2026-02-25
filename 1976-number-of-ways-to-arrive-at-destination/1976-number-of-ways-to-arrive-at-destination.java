class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = adjList(n, roads);

        long[] dis = new long[n];
        long[] count = new long[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        count[0] = 1;

        pq.offer(new long[] { 0, 0 });

        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] nodeArray = pq.poll();
            int node = (int) nodeArray[0];
            long d = nodeArray[1];

            if (d > dis[node])
                continue;

            for (int[] arr : adj.get(node)) {
                int next = arr[0];
                long nd = d + arr[1];

                if (nd < dis[next]) {
                    dis[next] = nd;
                    count[next] = count[node];
                    pq.offer(new long[] { next, nd });
                } else if (nd == dis[next]) {
                    count[next] = (count[next] + count[node]) % mod;
                }
            }
        }

        return (int) (count[n - 1] % mod);
    }

    private List<List<int[]>> adjList(int n, int[][] roads) {
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