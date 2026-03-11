class Solution {
    public int mySqrt(int x) {
        int lb = 0;
        int start = 0;
        int end = x / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int product = mid * mid;
            if (product == x) {
                return mid;
            }
            if (product > x) {
                end = mid - 1;
            } else {
                lb = mid;
                start = mid + 1;
            }
        }
        return lb;
    }
}