class Solution {
    public int mod = 1000000007;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        for(int num : hFences) {
            h.add(num);
        }
        for(int num : vFences) {
            v.add(num);
        }

        h.add(1);
        h.add(m);
        v.add(1);
        v.add(n);
        Collections.sort(h);
        Collections.sort(v);

        Set<Integer> heights = getDiffs(h);
        Set<Integer> widths = getDiffs(v);
        int max = 0;
        for(int num : heights) {
            if(widths.contains(num)) {
                max = Math.max(num, max);
            }
        }

        if(max == 0) {
            return -1;
        }

        long area = (long) max * max;
        return (int) (area % mod);
    }

    public Set<Integer> getDiffs(List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                set.add(list.get(j) - list.get(i));
            }
        }
        return set;
    }
}