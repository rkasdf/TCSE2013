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
        if(root==null)
            return 0;
        int ldepth = minDepth(root.left)+1;
        int rdepth = minDepth(root.right)+1;
        if(root.left==null&&root.right!=null)
            return rdepth;
        if(root.right==null&&root.left!=null)
            return ldepth;
        return ldepth<rdepth?ldepth:rdepth;
    }
}
