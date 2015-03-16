public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode prev = root, current;
        while (prev != null) {
            current = prev;
            while (current != null) {
                if (current.left != null)
                    current.left.next = current.right == null ? findNextPointer(current.next) : current.right;
                if (current.next != null && current.right != null)
                    current.right.next = findNextPointer(current.next);
                current = current.next;
            }
            prev = findNextPointer(prev);
        }
    }

    private TreeLinkNode findNextPointer(TreeLinkNode current) {
        while (current != null) {
            TreeLinkNode node = current.left == null ? current.right : current.left;
            if (node != null) return node;
            current = current.next;
        }
        return null;
    }
}