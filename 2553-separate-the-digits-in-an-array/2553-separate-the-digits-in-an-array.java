class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            segregate(nums[i], ans);
        }

        Collections.reverse(ans);
        int size = ans.size();

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = ans.get(i);
        }

        return result;

    }

    private void segregate(int n, List<Integer> ans) {
        while (n != 0) {
            ans.add(n % 10);
            n = n / 10;
        }
    }
}