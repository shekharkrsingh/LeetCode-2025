class Solution {

    public double separateSquares(int[][] squares) {
        double result = 0;
        double low = 0, high = 0;

        for (int[] s : squares) {
            high = Math.max(s[1] + s[2], high);
        }

        while (high - low > 1e-5) {
            double mid = low + (high - low) / 2.0;

            int area = calculate(mid, squares);

            if (area == 0)
                high = mid;
            else if(area==1)
                low = mid;
            else
                high=mid;
        }

        return low;
    }

    int calculate(double mid, int[][] squares) {
        double areau = 0;
        double areal = 0;

        for (int[] s : squares) {
            int x = s[0];
            int y = s[1];
            int l = s[2];

            if (y >= mid) {
                areau += (double)((long)l * (long)l);
            } else if (y + l < mid) {
                areal += (double)((long)l * (long)l);
            } else {
                double upperPart = (double)Math.max(0, (y + (long)l - mid) * (long)l);
                double lowerPart = (double)Math.max(0, (mid - y) * (long)l);

                areau += upperPart;
                areal += lowerPart;
            }
        }

        if (areal==areau)
            return 0;

        if (areal < areau)
            return 1;

        return 2;
    }

}