public class solution {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
      return false;
    boolean[][][] opt = new boolean[s1.length()][s1.length()][s1
        .length() + 1];
    for (int i = 0; i < s1.length(); i++) {
      for (int j = 0; j < s2.length(); j++) {
        opt[i][j][1] = s1.charAt(i) == s2.charAt(j);
      }
    }
    for (int len = 2; len <= s1.length(); len++) {
      for (int i1 = 0; i1 <= s1.length() - len; i1++) {
        for (int i2 = 0; i2 <= s2.length() - len; i2++) {
          for (int slice = 1; slice < len; slice++) {
            if (opt[i1][i2][len])
              continue;
            opt[i1][i2][len] |= opt[i1][i2][slice]
                && opt[i1 + slice][i2 + slice][len - slice]
                || opt[i1][i2 + len - slice][slice]
                && opt[i1 + slice][i2][len - slice];
          }
        }
      }
    }
    return opt[0][0][s1.length()];
  }

  public boolean isScramble2(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() != s2.length())
      return false;
    if (s1.equals(s2))
      return true;
    char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    if(!Arrays.equals(chars1, chars2)) 
      return false;
    for (int i = 1; i < s1.length(); i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i))
          && isScramble(s1.substring(i), s2.substring(i)))
        return true;
      if (isScramble(s1.substring(0, i),
          s2.substring(s2.length() - i))
          && isScramble(s1.substring(i),
              s2.substring(0, s2.length() - i)))
        return true;
    }
    return false;
  }
}
