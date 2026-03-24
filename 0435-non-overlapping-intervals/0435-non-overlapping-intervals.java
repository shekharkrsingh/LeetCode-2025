class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int prev = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(prev>intervals[i][0]){
                cnt++;
            }else{
                prev=intervals[i][1];
            }
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        prev = Integer.MIN_VALUE;
        int cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] < prev) {
                cnt2++;
            } else {
                prev = intervals[i][1];
            }
        }

        return Math.min(cnt, cnt2);
    }
}