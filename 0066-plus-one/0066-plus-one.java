class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int rem = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] + rem > 9) {
                rem = 1;
                digits[i] = 0;
                continue;
            }
            digits[i] = digits[i] + rem;
            return digits;
        }
        if (rem == 1) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = rem;
            for (int i = 1; i <= n; i++) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}