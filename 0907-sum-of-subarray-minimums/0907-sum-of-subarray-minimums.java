class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];
        int[] post = new int[n];

        long cnt = 0;
        int mod = 1_000_000_007;

        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pre[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            post[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long left = i - pre[i];
            long right = post[i] - i;
            cnt = (cnt + (left * right * arr[i]) % mod) % mod;
        }

        return (int) cnt;
    }
}