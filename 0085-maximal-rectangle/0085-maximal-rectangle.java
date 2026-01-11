class Solution {

    public int solve(int[] height){
        int maxarea = 0;
        int n = height.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i <= n; i++){
            int current = (i == n) ? 0 : height[i];

            while(!st.isEmpty() && current < height[st.peek()]){
                int h = height[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();
                int width = i - left - 1;
                maxarea = Math.max(maxarea, h * width);
            }
            st.push(i);
        }
        return maxarea;
    }

    public int maximalRectangle(char[][] matrix) {
        int maxarea = 0;
        int n = matrix[0].length;
        int[] height = new int[n];
        Arrays.fill(height, 0);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            maxarea = Math.max(maxarea, solve(height));
        }
        return maxarea;
    }
}