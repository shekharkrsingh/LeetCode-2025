class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Character> st = new ArrayDeque<>();
        int idx = 0;
        while (idx != n) {
            char ch = num.charAt(idx);
            if (st.isEmpty() || k == 0) {
                st.push(ch);
                idx++;
            } else {
                if (st.peek() > ch) {
                    st.pop();
                    k--;
                } else {
                    st.push(ch);
                    idx++;
                }
            }
        }
        while(k!=0){
            st.poll();
            k--;
        }

        while (!st.isEmpty() && st.peekLast() == '0') {
            st.pollLast();
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.peekLast());
            st.pollLast();
        }

        if (res.length() == 0) {
            res.append("0");
        }

        return res.toString();

    }
}