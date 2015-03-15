public class ConstructBinaryTreefromPreorderandInorderTraversal {
   private Map<Integer,Integer> map;
   private int[] preorder;
	
   public TreeNode buildTree(int[] preorder, int[] inorder) {
	   if(preorder.length==0) return null;
	   map = new HashMap<Integer,Integer>();
	   this.preorder = preorder;
	   for(int i=0;i<inorder.length;i++){
		   map.put(inorder[i], i);
	   }
	   TreeNode root = new TreeNode(preorder[0]);
	   dfs(root,0, preorder.length-1, 0, inorder.length-1 );
	   return root;      
   }
   
   private void dfs(TreeNode node, int preleft, int preright, int inleft, int inright){
	   int number = map.get(preorder[preleft]);
	   if(inleft < number){
		  node.left= new TreeNode(preorder[preleft+1]);
		  dfs(node.left,preleft+1,preleft+(number-inleft), inleft,number-1);
	   }
	   if(inright > number){
		   node.right = new TreeNode(preorder[preleft+(number-inleft)+1]);
		   dfs(node.right,preleft+(number-inleft)+1,preright,number+1,inright);
	   }
	   return;	   
   }
}
