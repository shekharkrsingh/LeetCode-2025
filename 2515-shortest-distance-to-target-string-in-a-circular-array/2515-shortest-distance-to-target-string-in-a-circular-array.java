class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[(startIndex + i) % n].equals(target)) {
                res = i;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (words[(startIndex - i + n) % n].equals(target)) {
                res = Math.min(res, i);
                break;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}