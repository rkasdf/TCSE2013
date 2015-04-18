public class Solution {
  public int minCut(String s) {
      if(s == null || s.length()==0)
          return 0;
    int[] res = new int[s.length() + 1];
    boolean[][] dict = new boolean[s.length()][s.length()];
    res[0] = 0;
    for(int i = 0; i < s.length(); i++) {
      res[i + 1] = i + 1;
      for(int j = 0; j <= i; j++) {
        if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dict[j + 1][i - 1])) {
          dict[j][i] = true;
          res[i + 1] = Math.min(res[i + 1], res[j] + 1);
        }
      }
    }
    return res[s.length()] - 1;
  }
}
