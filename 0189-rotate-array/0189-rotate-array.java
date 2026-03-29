class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        swap(nums, n, 0, n - k - 1);
        swap(nums, n, n - k, n - 1);
        swap(nums, n, 0, n - 1);
    }

    private void swap(int[] nums, int n, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}