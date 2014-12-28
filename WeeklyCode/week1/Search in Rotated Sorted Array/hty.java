package iscas.leetcode.hty.sortarray;

/**
 * Created by iscas.leetcode.hty on 14/12/17.
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */
public class Solution {

    public static int search(int[] A, int target) {
        if (A.length == 0) {
            return -1;
        }

        int left = 0;
        int right = A.length - 1;
        int mid = -1;

        while (left <= right) {
            mid = (left + right) >> 1;

            if (A[mid] == target) {
                return mid;
            } else if (A[left] <= A[mid]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
