/**
 * Created by LL on 2015/1/22.
 */
public class RegExpMatchRecusion {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    } // brute force

    public boolean isMatch(String s, String p, int sStart, int pStart) {
        int pLen = p.length(), sLen = s.length();
        if (pStart == pLen) {
            return sStart == sLen;
        }
        int si = sStart, pi = pStart;
        if (pi == pLen - 1 || p.charAt(pi + 1) != '*') {
            if (si == sLen || s.charAt(si) != p.charAt(pi) && p.charAt(pi) != '.') {
                return false;
            } else {
                return isMatch(s, p, si + 1, pi + 1);
            }
        }
        while (si < sLen && (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi))) {
            if (isMatch(s, p, si, pi + 2)) {
                return true;
            }
            si++;
        }
        return isMatch(s, p, si, pi + 2);
    }
}
