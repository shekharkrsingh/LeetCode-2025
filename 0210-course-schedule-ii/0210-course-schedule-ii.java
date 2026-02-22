class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adj = adjecencyList(numCourses, prerequisites);
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < n; i++) {
            inDegree[prerequisites[i][1]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        bfs(q, adj, topo, inDegree);

        if(topo.size()!=numCourses){
            return new int[0];
        }
        Collections.reverse(topo);

        return topo.stream().mapToInt(i -> i).toArray();
    }

    private void bfs(Queue<Integer> q, List<List<Integer>> adj, List<Integer> topo, int[] inDegree) {
        while (!q.isEmpty()) {

            int node = q.poll();
            topo.add(node);
            List<Integer> list = adj.get(node);

            for (int i : list) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }

        }
    }

    private List<List<Integer>> adjecencyList(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            adj.get(arr[0]).add(arr[1]);
        }

        return adj;
    }
}