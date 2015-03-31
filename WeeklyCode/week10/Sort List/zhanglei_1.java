public class Solution {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        return merge(mergeSort(head), mergeSort(fast));
    }

    private ListNode merge(ListNode prev, ListNode last) {
        ListNode current = new ListNode(0), result = current;

        while (prev != null && last != null) {
            if (prev.val <= last.val) {
                current.next = prev;
                prev = prev.next;
            } else {
                current.next = last;
                last = last.next;
            }
            current = current.next;
        }

        if (prev != null) current.next = prev;
        if (last != null) current.next = last;
        return result.next;
    }
}