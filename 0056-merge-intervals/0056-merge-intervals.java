class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { intervals[0][0], intervals[0][1] });
        for (int i = 1; i < n; i++) {
            int len = list.size() - 1;
            if (intervals[i][0] <= list.get(len)[1]) {
                list.get(len)[1] = Math.max(list.get(len)[1], intervals[i][1]);
            } else {
                list.add(new int[] { intervals[i][0], intervals[i][1] });
            }
        }

        int len = list.size();

        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}