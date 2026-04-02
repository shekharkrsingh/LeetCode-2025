class Solution {
    public int countGoodNumbers(long n) {
        long total = 1;
        total = mathPow(20, n / 2) % 1000000007;
        if (n % 2 != 0)
            total = (total * 5) % 1000000007;
        return (int) (total % 1000000007);
    }

    private long mathPow(int n, long m) {
        long result = 1;
        long base = n;
        long mod = 1000000007;
        while (m > 0) {
            if ((m & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            m >>= 1;
        }
        return result;
    }
}