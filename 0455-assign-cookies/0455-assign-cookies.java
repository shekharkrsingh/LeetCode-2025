class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n1 = g.length;
        int n2 = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int first = 0;
        int second = 0;

        while (first < n1 && second < n2) {
            if (g[first] <= s[second])
                first++;
            second++;
        }

        return first;
    }
}