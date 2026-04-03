class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        sol(n - 1, nums, list, result);
        return result;
    }

    private void sol(int idx, int[] nums, List<Integer> list, List<List<Integer>> result) {
        if (idx < 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        sol(idx - 1, nums, list, result);
        list.remove(list.size() - 1);
        sol(idx - 1, nums, list, result);
    }
}