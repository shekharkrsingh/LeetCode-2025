class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int j = 0;
        int maxFreq = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'A';
            freq[idx]++;
            maxFreq = Math.max(maxFreq, freq[idx]);

            while ((i - j + 1) - maxFreq > k) {
                freq[s.charAt(j) - 'A']--;
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}