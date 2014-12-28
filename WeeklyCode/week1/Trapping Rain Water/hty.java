package iscas.leetcode.hty.trappingrain;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * Created by hty on 2014/12/19.
 */
public class Solution {

    public static int trap(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int second = -1;
        int area = 0;
        while (left < right) {
            if (A[left] <= A[right]) {
                if (second > A[left]) {
                    area += second - A[left];
                } else if (second < A[left]){
                    second = A[left];
                }
                left++;
            } else {
                if (second > A[right]) {
                    area += second - A[right];
                } else if (second < A[right]){
                    second = A[right];
                }
                right--;
            }
        }
        return area;
    }
}
