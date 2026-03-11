class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0){
            return x;
        }
        long lb = 0;
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long product = mid * mid;
            if (product == x) {
                return (int)mid;
            }
            if (product > x) {
                end = mid - 1;
            } else {
                lb = mid;
                start = mid + 1;
            }
        }
        return (int)lb;
    }
}