class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && st.peek() > 0 && a < 0) {
                int top = st.peek();

                if (Math.abs(top) < Math.abs(a)) {
                    st.pop(); 
                    continue;
                } else if (Math.abs(top) == Math.abs(a)) {
                    st.pop(); 
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}