public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
          return 0;
        }
        int[] table = kmp_table(needle.toCharArray());
        int m = 0, i = 0;
        while((m + i) < haystack.length()) {
          if(needle.charAt(i) == haystack.charAt(m + i)) {
            if(i ==  needle.length() - 1){
              return m;
            }
            i++;
          } else {
            if(table[i] > -1) {
              m = m + i - table[i];
              i = table[i];
            } else {
              i = 0;
              m++;
            }
          }
        }
        return -1;
    }

    private int[] kmp_table(char[] pattern) {
        int[] result = new int[pattern.length];
        result[0] = -1;
        if(pattern.length > 1) {
          result[0] = -1;
        }
        int pos = 2, cnd = 0;
        while(pos < pattern.length) {
          if(pattern[pos - 1] == pattern[cnd]) {
            cnd++;
            result[pos] = cnd;
            pos++;
          } else if(cnd > 0){
            cnd = result[cnd];
          } else {
            result[pos] = 0;
            pos++;
          }
        }
        return result;
    }
}
