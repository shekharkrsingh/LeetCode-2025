class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] pre = new int[n];
        int[] post = new int[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.poll();
            }

            // if (st.isEmpty()) {
            //     pre[i] = -1;
            // } else {
            //     pre[i] = st.peek();
            // }

            if(!st.isEmpty()){
                res=Math.max(res, (i-st.peek())*heights[i]);
            }else{
                System.out.println("ddfdfdfd");
                res=Math.max(res, i*heights[i]);
            }


            st.push(i);
        }

        // st.clear();

        // for (int i = n - 1; i >= 0; i--) {
        //     while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        //         st.poll();
        //     }

        //     if (st.isEmpty()) {
        //         post[i] = n;
        //     } else {
        //         post[i] = st.peek();
        //     }

        //     st.push(i);
        // }

        // for (int i = 0; i < n; i++) {
        //     res = Math.max(res, (post[i] - pre[i] - 1) * heights[i]);
        // }

        return res;

    }
}