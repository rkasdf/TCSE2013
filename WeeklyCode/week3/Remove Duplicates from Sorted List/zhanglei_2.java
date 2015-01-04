public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }

        while (head.next != null && head.val == head.next.val)
            head = head.next;

        return deleteDuplicates(head.next);
    }
}