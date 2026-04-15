class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : heights[i];

            while (!st.isEmpty() && curr < heights[st.peek()]) {
                int height = heights[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();

                int w = right - left - 1;
                maxArea = Math.max(maxArea, height * w);
            }

            st.push(i);
        }

        return maxArea;
    }
}