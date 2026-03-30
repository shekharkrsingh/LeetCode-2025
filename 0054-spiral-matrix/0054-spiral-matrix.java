class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int rs = 0, re = m - 1;
        int cs = 0, ce = n - 1;

        List<Integer> list = new ArrayList<>();

        while (rs <= re && cs <= ce) {

            for (int i = rs; i <= re; i++) {
                list.add(matrix[cs][i]);
            }
            cs++;

            for (int i = cs; i <= ce; i++) {
                list.add(matrix[i][re]);
            }
            re--;

            if (cs <= ce) {
                for (int i = re; i >= rs; i--) {
                    list.add(matrix[ce][i]);
                }
                ce--;
            }

            if (rs <= re) {
                for (int i = ce; i >= cs; i--) {
                    list.add(matrix[i][rs]);
                }
                rs++;
            }
        }

        return list;
    }
}