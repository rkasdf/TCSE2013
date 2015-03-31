public class Solution {
    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode mid = partition(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }

    private ListNode partition(ListNode low, ListNode high) {
        int pivot = low.val;
        ListNode ptr = low;
        for (ListNode current = low.next; current != high; current = current.next) {
            if (current.val < pivot) {
                ptr = ptr.next;
                swap(current, ptr);
            }
        }
        swap(ptr, low);
        return ptr;
    }

    private void swap(ListNode p, ListNode q) {
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}