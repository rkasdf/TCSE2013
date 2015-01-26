public class Solution {
  public boolean isMatch(String s, String p) {
    return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  private boolean isMatch(char[] s, int index, char[] p, int offset) {
    if (offset == p.length) {
      return index == s.length;
    }
    if ((offset + 1 < p.length) && p[offset + 1] == '*') {
      while (index < s.length
          && (s[index] == p[offset] || p[offset] == '.')) {
        if (isMatch(s, index, p, offset + 2)) {
          return true;
        }
        index++;
      }
      return isMatch(s, index, p, offset + 2);
    } else {
      if (index < s.length && (s[index] == p[offset] || p[offset] == '.')) {
        return isMatch(s, ++index, p, ++offset);
      }
    }
    return false;
  }
}
