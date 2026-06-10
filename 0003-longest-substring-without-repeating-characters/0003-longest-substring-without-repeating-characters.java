class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch)+1) ;
            }
            map.put(ch, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}