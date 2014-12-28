package iscas.leetcode.hty.duplicatearray2;

import java.util.Arrays;

/**
 * Created by hty on 2014/12/26.
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 */
public class Solution {

    public int removeDuplicates(int[] A) {
        int note = 0;
        int find = 1;
        int temp = 1;
        int length = A.length;

        if (length < 3)
            return length;

        while (find < length) {
            if (A[find] == A[note]) {
                if (temp < 2) {
                    A[++note] = A[find++];
                    temp ++;
                } else {
                    find++;
                }
            } else {
                temp = 1;
                A[++note] = A[find++];
            }
        }

        A = Arrays.copyOfRange(A, 0 ,note + 1);

        return note + 1;
    }

    public int removeDuplicates(int[] A, int n) {
        int note = 0;
        int find = 1;
        int temp = 1;
        int length = A.length;

        if (length < n + 1)
            return length;

        while (find < length) {
            if (A[find] == A[note]) {
                if (temp < n) {
                    A[++note] = A[find++];
                    temp ++;
                } else {
                    find++;
                }
            } else {
                temp = 1;
                A[++note] = A[find++];
            }
        }

        A = Arrays.copyOfRange(A, 0 ,note + 1);

        return note + 1;
    }

}
