class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pas = new ArrayList<>();

        if (numRows == 0) return pas;

        List<Integer> first = new ArrayList<>();
        first.add(1);
        pas.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            for (int j = 1; j < i; j++) {
                int x = pas.get(i - 1).get(j - 1);
                int y = pas.get(i - 1).get(j);
                list.add(x + y);
            }

            list.add(1);
            pas.add(list);
        }

        return pas;
    }
}