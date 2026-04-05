class Solution {
    public List<Integer> findGoodIntegers(int n) {
        int ul = (int) Math.cbrt(n);
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        System.out.println(ul);
        for (int i = 0; i <= ul; i++) {
            for (int j = i + 1; j <= ul; j++) {
                int cal = (int) (Math.pow(i, 3) + Math.pow(j, 3));
                if (cal <= n)
                    map.put(cal, map.getOrDefault(cal, 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                result.add(e.getKey());
            }
        }

        Collections.sort(result);

        return result;

    }
}