package string;

/**
 * 字符串匹配算法
 * 暴力求解算法，时间复杂度O(m*n)
 */

public class Solution_3 {
    public int strStr(String haystack, String needle) {
        int i, j = 0;

        while (j <= haystack.length() - needle.length()) {
            for (i = needle.length() - 1; i >= 0 && haystack.charAt(i + j) == needle.charAt(i); i--) ;
            if (i < 0)
                return j;
            else
                j++;
        }

        return -1;
    }
}
