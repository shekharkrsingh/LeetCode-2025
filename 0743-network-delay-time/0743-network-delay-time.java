class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = adjList(times, n);

        int[] delay = new int[n + 1];
        Arrays.fill(delay, 100000);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        delay[k] = 0;
        pq.offer(new int[] { k, 0 });

        dij(pq, adj, delay);

        int maxVal = 0;

        for (int i = 1; i <= n; i++) {
            if (delay[i] == 100000) {
                return -1;
            }
            maxVal = Math.max(maxVal, delay[i]);
        }

        return maxVal;
    }

    private void dij(PriorityQueue<int[]> pq, List<List<int[]>> adj, int[] delay) {
        while (!pq.isEmpty()) {
            int[] nodeArray = pq.poll();
            int node = nodeArray[0];
            int d = nodeArray[1];

            List<int[]> list = adj.get(node);

            for (int[] arr : list) {
                int nd = d + arr[1];
                if (delay[arr[0]] > nd) {
                    delay[arr[0]] = nd;
                    pq.offer(new int[] { arr[0], nd });
                }
            }
        }
    }

    private List<List<int[]>> adjList(int[][] times, int n) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new int[] { times[i][1], times[i][2] });
        }

        return adj;
    }
}