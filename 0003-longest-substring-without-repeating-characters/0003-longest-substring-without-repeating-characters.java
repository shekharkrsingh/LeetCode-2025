class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j=Math.max(map.get(ch)+1,j);
            } 
            map.put(ch, i);
            res=Math.max(res,i-j+1);
        }
        return res;
    }
}