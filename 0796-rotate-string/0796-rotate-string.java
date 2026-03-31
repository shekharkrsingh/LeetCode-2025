class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if (n != m)
            return false;
        if (s.equals(goal))
            return true;
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            char ch = sb.charAt(0);
            sb.delete(0, 1);
            sb.append(ch + "");
            if (goal.equals(sb.toString()))
                return true;
        }

        return false;

    }
}