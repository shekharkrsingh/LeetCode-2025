class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int start = 0;
        int cnt = 0;
        int minLength = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                cnt++;
            }
            if (cnt >= k) {
                while (s.charAt(start) == '0' || cnt > k) {
                    if (s.charAt(start) == '1') {
                        cnt--;
                    }
                    start++;
                }
                if (minLength > i - start + 1) {
                    res = s.substring(start, i + 1);
                } else if (minLength == i - start + 1 && res.compareTo(s.substring(start, i + 1)) > 0) {
                    res = s.substring(start, i + 1);
                }
                minLength = Math.min(minLength, i - start + 1);
            }
        }

        return res;
    }
}