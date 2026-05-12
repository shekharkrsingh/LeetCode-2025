class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;
        int energyReq = 0;
        int energy = 0;
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));
        for (int i = 0; i < n; i++) {
            if (tasks[i][1] > energy) {
                int en = tasks[i][1] - energy;
                energy += en;
                energyReq += en;
            }
            if (tasks[i][0] > energy) {
                int en = tasks[i][0] - energy;
                energy += en;
                energyReq += en;
            }

            energy -= tasks[i][0];
        }

        return energyReq;

    }
}