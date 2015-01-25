package iscas.leetcode.hty.strstr;

/**
 * Created by hty on 2015/1/18.
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer.
 * If you still see your function signature returns a char * or String, please click the reload button
 * to reset your code definition.
 */
public class Solution {
    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;

        int haylen = haystack.length();
        int neelen = needle.length();
        int i = 0, j = 0;
        for (; i < haylen && j < neelen; ) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return j == neelen ? i - j : -1;
    }

}
