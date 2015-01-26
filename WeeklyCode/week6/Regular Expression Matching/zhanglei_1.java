public class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int i, int j) {
        if (j == p.length()) return i == s.length();
        if (j == p.length() - 1) return i == s.length() - 1 && isEqual(s, p, i, j);

        if (p.charAt(j + 1) == '*')
            return isMatch(s, p, i, j + 2) || (isEqual(s, p, i, j) && isMatch(s, p, i + 1, j));

        return isEqual(s, p, i, j) && isMatch(s, p, i + 1, j + 1);
    }

    private boolean isEqual(String s, String p, int i, int j) {
        return i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
    }
}
