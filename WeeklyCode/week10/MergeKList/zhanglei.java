public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        int n = lists.size();
        if (n == 0) return null;
        while (n > 1) {
            int gap = (n + 1) / 2;
            for (int i = 0; i < n / 2; i++)
                lists.set(i, merge(lists.get(i), lists.get(i + gap)));
            n = gap;
        }
        return lists.get(0);
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