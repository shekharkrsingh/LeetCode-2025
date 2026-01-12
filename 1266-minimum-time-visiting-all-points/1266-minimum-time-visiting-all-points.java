class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;
        int n = points.length;

        for (int i = 1; i < n; i++) {
            
            int xMove = Math.abs(points[i][0] - points[i - 1][0]);
            int yMove = Math.abs(points[i][1] - points[i - 1][1]);

            int min = Integer.min(xMove, yMove);
            count += xMove + yMove - min;
        }

        return count;
    }
}