package iscas.leetcode.hty.reverselinklist;

/**
 * Created by hty on 2015/1/2.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode temphead = new ListNode(-1);
        temphead.next = head;

        ListNode pre_start = temphead;
        int count = 0;

        for (; count < m - 1; count++) {
            pre_start = pre_start.next;
        }

        ListNode start = pre_start.next;
        ListNode move = start;

        while (++count < n) {
            move = start.next;
            start.next = move.next;
            move.next = pre_start.next;
            pre_start.next = move;
        }

        return temphead.next;
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
