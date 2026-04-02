class Solution {
    public double myPow(double x, int n) {
        long N = n; 
        if (N >= 0) {
            return gPow(x, N);
        }
        return 1 / gPow(x, -N);
    }

    private double gPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;

        if (n % 2 == 0) {
            return gPow(x * x, n / 2);
        } else {
            return x * gPow(x * x, n / 2);
        }
    }
}