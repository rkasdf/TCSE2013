/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return convert(head, null);
    }
    
    public TreeNode convert(ListNode start, ListNode end) {
        if (start == end) return null;
        ListNode fast = start, mid = start;
        while (fast != end && fast.next != end) {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = convert(start, mid);
        root.right = convert(mid.next, end);
        return root;
    }
}
