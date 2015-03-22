public class Solution {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
    	if(root == null) return 0;
		dfs(root,1);   	
    	return minDepth;        
    }
	private void dfs(TreeNode node,int deep) {
		if(node == null){
			return;
		}
		if(node.left == null && node.right== null){
			minDepth = deep < minDepth?   deep : minDepth;
		}
		dfs(node.left,deep+1);
		dfs(node.right,deep+1);		
	}
}