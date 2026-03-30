import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);

                if (seen.contains(third)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(triplet); 
                    res.add(triplet);
                }

                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }
}