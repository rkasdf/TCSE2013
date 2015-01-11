package iscas.leetcode.hty.linklistcycle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hty on 2015/1/10.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class Solution {

    public ListNode detectCycleWithExtra(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode node = head;
        while (!set.contains(node) && node != null) {
            set.add(node);
            node = node.next;
        }
        return node;
    }

    public ListNode detectCycleNoExtra(ListNode head) {
        ListNode oncePointer = head;
        ListNode twicePointer = head;
        while (twicePointer != null && twicePointer.next != null) {
            oncePointer = oncePointer.next;
            twicePointer = twicePointer.next.next;
            if (oncePointer.equals(twicePointer))
                break;
        }
        if (twicePointer == null || twicePointer.next == null)
            return null;
        oncePointer = head;
        while (!oncePointer.equals(twicePointer)) {
            oncePointer = oncePointer.next;
            twicePointer = twicePointer.next;
        }
        return oncePointer;
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
