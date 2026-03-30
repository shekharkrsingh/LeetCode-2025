import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int a = 0, b = 0;
        int cnt1 = 0, cnt2 = 0;

        for (int num : nums) {
            if (num == a) {
                cnt1++;
            } else if (num == b) {
                cnt2++;
            } else if (cnt1 == 0) {
                a = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                b = num;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == a) cnt1++;
            else if (num == b) cnt2++;
        }

        List<Integer> result = new ArrayList<>();

        if (cnt1 > n / 3) result.add(a);
        if (cnt2 > n / 3) result.add(b);

        return result;
    }
}