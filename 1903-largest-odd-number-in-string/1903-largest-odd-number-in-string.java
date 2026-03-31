class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = n - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if ((ch - '0') % 2 != 0)
                flag = true;
            if (flag)
                sb.append(ch);
        }
        return sb.reverse().toString();
    }
}