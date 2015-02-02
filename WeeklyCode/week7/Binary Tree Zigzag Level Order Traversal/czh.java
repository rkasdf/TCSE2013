public class BinaryTreeZigzagLevelOrderTraversal {
	class NewNode{
		int level;
		TreeNode node;
		NewNode(int level, TreeNode node){
			this.level = level;
			this.node = node;
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> ansList = new LinkedList<List<Integer>>();
		List<NewNode> list = levelBfs(root);
		int i=0;
		int curLevel = -1;
		while(i<list.size()){
			curLevel = list.get(i).level;
			List<Integer> tmp = new LinkedList<Integer>();
			while(i<list.size()&&list.get(i).level == curLevel){
				tmp.add(list.get(i++).node.val);
			}
			List<Integer> leveList = new LinkedList<Integer>();
			if(curLevel%2==0){
				for(int j=0;j<tmp.size();j++)  leveList.add(tmp.get(j));
			}else{
				for(int j=tmp.size()-1;j>=0;j--)  leveList.add(tmp.get(j));
			}
			ansList.add(leveList);
		}
		return ansList;        
    }

	private List<NewNode> levelBfs(TreeNode treeNode) {
		List<NewNode> list = new LinkedList<NewNode>();
		if(treeNode == null) return list;
		Queue<NewNode> queue = new LinkedList<NewNode>();
		queue.add(new NewNode(0,treeNode));
		while(!queue.isEmpty()){
			NewNode peek = queue.poll();
			list.add(peek);
			if(peek.node.left!= null)
				queue.add(new NewNode(peek.level+1,peek.node.left));
			if(peek.node.right!= null)
				queue.add(new NewNode(peek.level+1,peek.node.right));			
		}
		return list;
	}
}
