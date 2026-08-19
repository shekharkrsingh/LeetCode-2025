class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int m = reservedSeats.length;
        Arrays.sort(reservedSeats, (a, b) -> Integer.compare(a[0], b[0]));
        int row = 1;
        int idx = 0;
        int cnt = 0;
        cnt += 2 * (reservedSeats[idx][0] - row);
        row = reservedSeats[idx][0];
        while (row <= n) {
            int[] arr = new int[10];
            Arrays.fill(arr, 0);
            while (idx < m && reservedSeats[idx][0] == row) {
                arr[reservedSeats[idx][1] - 1] = 1;
                idx++;
            }
            boolean flag = false;
            if (arr[1] == 0 && arr[2] == 0 && arr[3] == 0 && arr[4] == 0) {
                cnt++;
                flag = true;
            } else {
                flag = false;
            }
            if (!flag && arr[3] == 0 && arr[4] == 0 && arr[5] == 0 && arr[6] == 0) {
                cnt++;
                flag = true;
            } else {
                flag = false;
            }
            if (!flag && arr[5] == 0 && arr[6] == 0 && arr[7] == 0 && arr[8] == 0) {
                cnt++;
            }
            if (idx == m) {
                cnt += 2 * (n - row);
                break;
            } else {
                cnt += 2 * (reservedSeats[idx][0] - row - 1);
                row = reservedSeats[idx][0];
            }

        }

        return cnt;
    }
}