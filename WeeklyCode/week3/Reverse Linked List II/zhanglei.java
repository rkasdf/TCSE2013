public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode current = new ListNode(0);
        ListNode result = current;
        current.next = head;
        ListNode p = head, q;

        for (int i = 1; i < m; i++) {
            current = current.next;
            p = p.next;
        }

        for (int i = 0; i < n - m; i++) {
            q = p.next;
            p.next = q.next;
            q.next = current.next;
            current.next = q;
        }

        return result.next;
    }
}