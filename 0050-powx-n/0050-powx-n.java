class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            return gPow(x, n);
        }
        return 1 / gPow(x, (-1) * n);
    }

    private double gPow(double x, int n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return gPow(x * x, n / 2);
        } else {
            return x * gPow(x, n - 1);
        }
    }
}