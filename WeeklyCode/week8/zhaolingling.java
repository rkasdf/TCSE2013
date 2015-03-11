import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by LL on 2015/3/10.
 */
public class ConstructBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int len = preorder.length;
        TreeNode root = buildTree(preorder, inorder, 0, 0, len);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int len) {
        if (len == 0) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = 0;
        while (preorder[preStart] != inorder[inStart + i]) {
            i++;
        }
        root.left = buildTree(preorder, inorder, preStart + 1, inStart, i);
        root.right = buildTree(preorder, inorder, preStart + i + 1, inStart + i + 1, len - i - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 6, 3, 7, 8};
        int[] inorder = {4, 2, 6, 5, 1, 3, 7, 8};
        TreeNode root = new ConstructBinaryTree().buildTree(preorder, inorder);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
}
