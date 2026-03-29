class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n == 0 || m == 0) return "";

        int[] tFreq = new int[256];
        for (int i = 0; i < m; i++) {
            tFreq[t.charAt(i)]++;
        }

        int j = 0;
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (tFreq[ch] > 0) cnt++;

            tFreq[ch]--;

            while (cnt == m) {
                if (i - j + 1 < minWindow) {
                    minWindow = i - j + 1;
                    start = j;
                }

                char left = s.charAt(j);

                tFreq[left]++;
                if (tFreq[left] > 0) cnt--;

                j++;
            }
        }

        return minWindow == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minWindow);
    }
}