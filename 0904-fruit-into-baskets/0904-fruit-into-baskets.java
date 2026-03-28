class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int j = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(fruits[i]) || map.get(fruits[i]) == 0) {
                cnt++;
                map.put(fruits[i], 0);
            }
            map.put(fruits[i], map.get(fruits[i]) + 1);
            if (cnt > 2) {
                int val = map.get(fruits[j]);
                if (val == 1) {
                    cnt--;
                }
                map.put(fruits[j], val - 1);
                j++;
            }
            max = Math.max(i - j + 1, max);
        }

        return max;

    }
}