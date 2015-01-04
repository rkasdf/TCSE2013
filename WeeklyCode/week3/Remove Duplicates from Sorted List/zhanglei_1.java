public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;

        ListNode current = new ListNode(0);
        ListNode result = current;
        current.next = head;
        ListNode p = head;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                while (p.next != null && p.val == p.next.val)
                    p = p.next;
                current.next = p.next;
            } else {
                current = p;
            }
            p = p.next;
        }

        return result.next;
    }
}