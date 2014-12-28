package iscas.leetcode.hty.threesumclosest;

import java.util.Arrays;

/**
 * Created by hty on 2014/12/26.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class Solution {

    public static int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int result = 0;
        int abs = Integer.MAX_VALUE;
        int length = num.length;

        for (int i = 0; i < length; i++) {
            int left = i + 1;
            int right = length - 1;

            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                int tem = Math.abs(sum - target);
                if (tem < abs) {
                    abs = tem;
                    result = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return result;
                }
            }

        }

        return result;
    }
}
