public class Solution {
    public int minDepth(TreeNode root) {
        return minDepth(root,false);
    }
    private int minDepth(TreeNode root,boolean hasBrother) {
        if(root == null) return hasBrother?Integer.MAX_VALUE:0;
        int left = minDepth(root.left,root.right!=null);
        int right = minDepth(root.right,root.left!=null);
        if(left < right){
            return left+1;
        }else{
            return right+1;
        }
    }
}