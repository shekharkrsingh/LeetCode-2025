class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int tg = 0;
        int tc = 0;
        int g = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            tg += gas[i];
            tc += cost[i];
            g += gas[i];
            g -= cost[i];
            if (g < 0) {
                start = i + 1;
                g = 0;
            }
        }
        if (tc > tg) {
            return -1;
        }

        return start;
    }
}