class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int start = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!freq.containsKey(ch)) {
                freq.put(ch, 1);
            } else {
                freq.put(ch, freq.get(ch) + 1);
            }
            while (countDistintChar(freq) > k) {
                char startChar = s.charAt(start);
                freq.put(startChar, freq.get(startChar) - 1);
                start++;
            }

            maxLength = Math.max(maxLength, i - start + 1);

        }

        return maxLength;
    }

    private int countDistintChar(Map<Character, Integer> freq) {
        int totalCharacter = 0;
        int maxVal = 0;
        for (Map.Entry<Character, Integer> ch : freq.entrySet()) {
            totalCharacter += ch.getValue();
            maxVal = Math.max(maxVal, ch.getValue());
        }

        return totalCharacter - maxVal;
    }
}