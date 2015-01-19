public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l)))
                l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r)))
                r--;
            if (l == r)
                return true;

            char p = s.charAt(l);
            char q = s.charAt(r);
            if (p != q && Math.abs(p - q) != 32)
                return false;
            l++;
            r--;
        }
        return true;
    }
}
