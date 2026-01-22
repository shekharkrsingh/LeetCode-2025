class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        int count = 0;
        while (!isSorted(list)) {
            int t = list.size();
            int sum = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < t - 1; i++) {
                if (list.get(i) + list.get(i + 1) < sum) {
                    sum = list.get(i) + list.get(i + 1);
                    idx = i;
                }
            }
            count++;
            list.set(idx, sum);
            list.remove(idx + 1);
        }

        return count;

    }

    private boolean isSorted(List<Integer> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}