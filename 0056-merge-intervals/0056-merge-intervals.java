class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int k = list.size() - 1;
            if (intervals[i][0] <= list.get(k)[1]) {
                list.get(k)[1] = Math.max(list.get(k)[1], intervals[i][1]);
            } else {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}