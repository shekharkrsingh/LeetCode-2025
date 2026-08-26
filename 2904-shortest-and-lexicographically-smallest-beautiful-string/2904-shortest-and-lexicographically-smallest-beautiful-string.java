class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int start = 0;
        int cnt = 0;
        int minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        String res = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                cnt++;
            }
            sb.append(ch);
            if (cnt >= k) {
                while (s.charAt(start) == '0' || cnt > k) {
                    if (s.charAt(start) == '1') {
                        cnt--;
                    }
                    start++;
                    sb.deleteCharAt(0);
                }

                System.out.println(sb);

                if (minLength > i - start + 1) {
                    res = sb.toString();

                } else if (minLength == i - start + 1 && res.compareTo(sb.toString()) > 0) {
                    res = sb.toString();
                }
                minLength = Math.min(minLength, i - start + 1);
            }
        }

        return res;
    }
}