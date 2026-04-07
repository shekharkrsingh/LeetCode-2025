class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            st.push(nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            while (!st.isEmpty() && st.peek() <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nums[i] = -1;
            } else {
                nums[i] = st.peek();
            }
            st.push(val);
        }

        return nums;

    }
}