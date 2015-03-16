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
    public boolean isBalanced(TreeNode root) {
        if(getHeight(root)==null) return false;
        return true;
    }
    private Integer getHeight(TreeNode node){
        if(node == null) return 0;
        Integer leftH = getHeight(node.left);
        if(leftH == null) return null;
        Integer rightH = getHeight(node.right);
        if(rightH == null || Math.abs(leftH-rightH) >1) return null;
        return leftH > rightH ? leftH+1:rightH+1;
    }
}