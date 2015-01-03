package iscas.leetcode.hty.addtwonumber;

/**
 * Created by hty on 2015/1/2.
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode temp = result;
        ListNode tempL1 = l1;
        ListNode tempL2 = l2;
        int tempV1 = 0;
        int tempV2 = 0;
        int tempSum = 0;
        int carry = 0;

        while (tempL1 != null || tempL2 != null) {
            temp.next = new ListNode(0);
            temp = temp.next;

            if (tempL1 == null) {
                tempV1 = 0;
            } else {
                tempV1 = tempL1.val;
                tempL1 = tempL1.next;
            }

            if (tempL2 == null) {
                tempV2 = 0;
            } else {
                tempV2 = tempL2.val;
                tempL2 = tempL2.next;
            }

            tempSum = tempV1 + tempV2 + carry;
            temp.val = tempSum % 10;
            carry = tempSum / 10;

        }

        if (carry != 0) {
            temp.next = new ListNode(0);
            temp.next.val = 1;
        }

        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
