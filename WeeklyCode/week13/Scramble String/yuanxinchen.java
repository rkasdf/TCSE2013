public class solution {
    public boolean isScramble(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if(s1.length() == 0) return true;
        boolean[][][] opt = new boolean[s1.length()][s1.length()][s1.length() + 1];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
              opt[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int len = 2; len <= s1.length(); len++) {
            for(int st1 = 0; st1 <= s1.length() - len; st1++) {
              for(int st2 = 0; st2 <= s2.length() - len; st2++) {
                for(int slice = 1; slice < len; slice++) {
                  opt[st1][st2][len] |=
                      opt[st1][st2][slice] && opt[st1 + slice][st2 + slice][len - slice] ||
                      opt[st1][st2 + len - slice][slice] && opt[st1 + slice][st2][len - slice];
                }
              }
            }
        }
        return opt[0][0][s1.length()];
    }
}
