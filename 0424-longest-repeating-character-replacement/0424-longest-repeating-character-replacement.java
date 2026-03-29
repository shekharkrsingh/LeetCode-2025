class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
            int max = 0;
            int sum = 0;
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                max = Math.max(max, e.getValue());
                sum += e.getValue();
            }
            if (sum - max > k) {
                char ch2 = s.charAt(j);
                map.put(ch2, map.get(ch2) - 1);
                if(map.get(ch2)==0){
                    map.remove(ch2);
                }
                j++;
            }

            res = Math.max(i - j + 1, max);
        }

        return res;

    }
}