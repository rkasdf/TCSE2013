package iscas.leetcode.hty.reg;

/**
 * Created by hty on 2015/1/24.
 */
public class Solution {
    /**
     *if (*p == 0) return *s == 0;
      if (*(p+1) != '*')
      {
        if (*s != 0 && (*p == *s || *p == '.')) return isMatch(s+1, p+1);
        else return false;
      }
      else
      {
         while (*s != 0 && (*s == *p || *p == '.'))
        {
            if (isMatch(s, p+2)) return true;
            s++;
        }
        return (isMatch(s, p+2));
      }
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') ) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else {
            int length = s.length();
            int i = -1;
            while (i < length && (i < 0 || s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
