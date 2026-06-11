class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int totalSub = 0;
        int a = -1;
        int b = -1;
        int c = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a = i;
            } else if (ch == 'b') {
                b = i;
            } else {
                c = i;
            }
            if (a != -1 && b != -1 && c != -1) {
                int minIndex = Math.min(a, Math.min(b, c));
                totalSub += minIndex + 1;
            }
        }

        return totalSub;
    }
}