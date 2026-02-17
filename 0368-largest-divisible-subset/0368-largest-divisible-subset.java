class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n + 1];
        int[] track = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(track, -1);

        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                    if (dp[maxIdx] < dp[i]) {
                        maxIdx = i;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        while (maxIdx != -1) {
            list.add(nums[maxIdx]);
            maxIdx = track[maxIdx];
        }

        Collections.reverse(list);
        return list;
    }
}