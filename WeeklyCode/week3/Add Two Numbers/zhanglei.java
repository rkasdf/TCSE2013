public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (l1 != null || l2 != null) {
            ListNode node = new ListNode(0);
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)
                    + carry;
            node.val = sum % 10;
            carry = sum / 10;
            current.next = node;
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (carry != 0)
            current.next = new ListNode(1);

        return result.next;
    }
}