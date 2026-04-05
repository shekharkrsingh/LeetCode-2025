class Solution {
    public int mirrorFrequency(String s) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < 13; i++) {
            char ch = (char) ('a' + i);
            char rev = (char) ('a' + (25 - i));
            int cnt1 = 0;
            int cnt2 = 0;
            if (map.containsKey(ch)) {
                cnt1 = map.get(ch);
            }
            if (map.containsKey(rev)) {
                cnt2 = map.get(rev);
            }

            result += Math.abs(cnt1 - cnt2);
        }
        System.out.println(result);
        for (int i = 0; i < 5; i++) {
            char ch = (char) (i + '0');
            char rev = (char) ('0' + (9 - i));
            int cnt1 = 0;
            int cnt2 = 0;
            if (map.containsKey(ch)) {
                cnt1 = map.get(ch);
            }
            if (map.containsKey(rev)) {
                cnt2 = map.get(rev);
            }

            result += Math.abs(cnt1 - cnt2);
        }

        return result;
    }
}