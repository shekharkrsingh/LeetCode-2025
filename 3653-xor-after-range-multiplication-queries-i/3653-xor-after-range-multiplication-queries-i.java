class Solution {
    private static final int MOD = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int xor = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        for (int i = 0; i < m; i++) {
            pq.offer(queries[i]);
        }
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int l = arr[0];
            int r = arr[1];
            int k = arr[2];
            int v = arr[3];

            while (l <= r) {
                nums[l] = (int) ((long) nums[l] * v % MOD);
                l = l + k;
            }

        }

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        return xor;

    }
}