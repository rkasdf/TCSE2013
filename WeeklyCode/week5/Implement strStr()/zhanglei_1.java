package string;

/**
 * 字符串匹配算法
 * KMP算法，时间复杂度O(m+n)
 */

public class Solution_2 {
    public int strStr(String haystack, String needle) {
        return needle.length() == 0 ? 0 : kmpSearch(haystack, needle);
    }

    private int kmpSearch(String haystack, String needle) {
        int i = 0, j = 0;
        int[] next = getNextVal(needle);

        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else
                j = next[j]; // next[j]表示在j位置匹配出现不同的时候下一个匹配位置
        }

        return j == needle.length() ? i - j : -1;
    }

    private int[] getNextVal(String needle) {
        int[] next = new int[needle.length()];
        next[0] = -1;
        int k = -1, j = 0;

        while (j < needle.length() - 1) {
            if (k == -1 || needle.charAt(k) == needle.charAt(j)) {
                k++;
                j++;
                next[j] = needle.charAt(k) != needle.charAt(j) ? k : next[k];
            } else
                k = next[k];
        }

        return next;
    }
}
