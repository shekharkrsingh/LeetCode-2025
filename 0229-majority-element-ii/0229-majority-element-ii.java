class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        int cnt1 = 0;
        int cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != b) {
                a = nums[i];
                cnt1++;
                continue;
            }
            if (cnt2 == 0 && nums[i] != a) {
                b = nums[i];
                cnt2++;
                continue;
            }

            if (nums[i] != a) {
                if (nums[i] == b) {
                    cnt2++;
                } else {
                    cnt2--;
                }
            }

            if (nums[i] != b) {
                if (nums[i] == a) {
                    cnt1++;
                } else {
                    cnt1--;
                }
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == a) {
                cnt1++;
            }
            if (nums[i] == b) {
                cnt2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        System.out.println(cnt1 +" "+ cnt2);
        System.out.println(a +" "+ b);
        if (cnt1 > n / 3) {
            list.add(a);
        }
        if (cnt2 > n / 3) {
            list.add(b);
        }

        return list;
    }
}