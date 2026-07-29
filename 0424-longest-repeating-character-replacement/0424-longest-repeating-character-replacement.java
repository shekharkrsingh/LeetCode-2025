class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            while (countDE(freq) > k ) {
                char startC = s.charAt(start);
                freq[startC-'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;

    }

    private int countDE(int[] freq) {
        int cnt = 0;
        int max=0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                cnt+=freq[i];
            }
            max=Math.max(freq[i], max);
        }
        return cnt-max;
    }
}