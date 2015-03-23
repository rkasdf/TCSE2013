public class Solution {
    private List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return createBST(0, list.size() - 1);
    }

    private TreeNode createBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createBST(start, mid - 1);
        root.right = createBST(mid + 1, end);
        return root;
    }
}