class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        if (arr[start] == 0) {
            return true;
        }

        boolean[] visited = new boolean[n];
        visited[start] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (arr[node] == 0)
                return true;
            if (node - arr[node] >= 0 && !visited[node - arr[node]]) {
                visited[node - arr[node]] = true;
                q.offer(node - arr[node]);
            }
            if (node + arr[node] < n && !visited[node + arr[node]]) {
                visited[node + arr[node]] = true;
                q.offer(node + arr[node]);
            }
        }

        return false;
    }
}