class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        int k = 0;

        while (k <= j) {
            if (nums[k] == 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                i++;
            }
            if (nums[k] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j--;
            }
            if (nums[k] == 1) {
                k++;
            }
            if(k<i){
                k=i;
            }
        }
    }
}