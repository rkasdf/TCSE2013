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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p;
        int result = 1;
        int levelNum = 1;
        int newNum = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            p = queue.poll();
            levelNum--;
            if (p.left == null && p.right == null) {
                return result;
            } else if (p.left == null) {
                queue.offer(p.right);
                newNum++;
            } else if (p.right == null) {
                queue.offer(p.left);
                newNum++;
            } else {
                queue.offer(p.left);
                queue.offer(p.right);
                newNum += 2;
            }
            if (levelNum == 0) {
                result++;
                levelNum = newNum;
                newNum = 0;
            }
        }
        return result;
    }
}
