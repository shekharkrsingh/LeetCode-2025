class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        int cnt = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                cnt++;
            if (ch == ')')
                cnt--;
            if ((cnt == 1 && ch == '(') || (cnt == 0 && ch == ')'))
                continue;

            sb.append(ch);
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
}