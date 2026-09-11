class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int number = 0;
        int[] digitsFreq = new int[10];
        for (int i = 0; i < n; i++) {
            digitsFreq[digits[i]]++;
        }
        return sol(1, digitsFreq);
    }

    private int sol(int position, int[] digitsFreq) {
        if (position > 3) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (position == 1 && i == 0) {
                continue;
            }
            if (digitsFreq[i] != 0 && !(position == 3 && i % 2 != 0)) {
                digitsFreq[i]--;
                cnt += sol(position + 1, digitsFreq);
                digitsFreq[i]++;
            }

        }
        return cnt;
    }
}