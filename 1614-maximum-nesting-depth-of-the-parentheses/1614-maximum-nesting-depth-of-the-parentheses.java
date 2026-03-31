class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                cnt++;
            if (ch == ')')
                cnt--;
            max = Math.max(max, cnt);
        }

        return max;
    }
}