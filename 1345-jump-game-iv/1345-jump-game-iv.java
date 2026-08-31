class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int index = node[0];
            int jumps = node[1];
            if (index == n - 1) {
                return jumps;
            }

            if (index - 1 >= 0 && !visited[index - 1]) {
                visited[index - 1] = true;
                q.offer(new int[]{index - 1, jumps + 1});
            }

            if (index + 1 < n && !visited[index + 1]) {
                visited[index + 1] = true;
                q.offer(new int[]{index + 1, jumps + 1});
            }

            List<Integer> list = map.get(arr[index]);

            if (list != null) {
                for (int val : list) {
                    if (!visited[val]) {
                        visited[val] = true;
                        q.offer(new int[]{val, jumps + 1});
                    }
                }
                map.remove(arr[index]);
            }
        }

        return -1;
    }
}
