public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head, fast = head;
        while (true) {
            if (fast.next == null || fast.next.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}