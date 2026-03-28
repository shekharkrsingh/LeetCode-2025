class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        Map<Character, Integer> map=new HashMap<>();
        int j=0;
        int max=0;

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                j=Math.max(map.get(ch)+1, j);
            }
            max=Math.max(i-j+1, max);
            map.put(ch, i);
        }

        return max;
    }
}