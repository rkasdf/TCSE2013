public class BalancedBinaryTree {
	 class NodeInfo{
		 int level;
		 boolean state;
		 public NodeInfo(int level, boolean state){
			 this.level = level;
			 this.state = state;
		 } 
	 }
	 
	 public boolean isBalanced(TreeNode root) {
	        return isBalancedDFS(root).state;	        
	  }
	
	 private NodeInfo isBalancedDFS(TreeNode node) {
		 if(node == null){
			 return new NodeInfo(0,true);
		 }		 
		 NodeInfo left = isBalancedDFS(node.left);
		 NodeInfo right = isBalancedDFS(node.right);
		 if (left.state && right.state && Math.abs(left.level - right.level) < 2 ){
			 return new NodeInfo(Math.max(left.level, right.level)+1,true);
		 }else{
			 return new NodeInfo(-1,false);
		 }	        
	 }
}
