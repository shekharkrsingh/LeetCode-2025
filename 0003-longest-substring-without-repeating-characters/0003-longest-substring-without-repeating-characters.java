class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch) ) {
                j = Math.max(j, map.get(ch)+1);
            }
            res = Math.max(i - j+1, res);
            map.put(ch, i);
        }
        return res;
    }
}