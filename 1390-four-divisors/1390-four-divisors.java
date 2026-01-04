class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            int s = fourDevisor(n);
            sum += s;
        }
        return sum;
    }

    private int fourDevisor(int n) {
        int p = perfectCube(n);
        if (p > 1 && isPrime(p)) {
            return 1 + p + p * p + n;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int j = n / i;
                if (i != j && isPrime(i) && isPrime(j)) {
                    return 1 + i + j + n;
                }
                return 0;
            }
        }
        return 0;
    }

    private int perfectCube(int n) {
        int low = 1, high = (int) Math.cbrt(n) + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long cube = (long) mid * mid * mid;
            if (cube == n) {
                return mid;
            }
            if (cube < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    private boolean isPrime(int x) {
        if (x < 2)
            return false;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
