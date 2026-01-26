class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
        }
        List<List<Integer>> result = new ArrayList<>();
        System.out.println(min);
        for (int i = 1; i < n; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) == min) {
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                result.add(list);
            }
        }
        return result;
    }
}