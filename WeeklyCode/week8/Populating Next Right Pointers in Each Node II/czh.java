public class PopulatingNextRightPointersinEachNodeII {
	
    public void connect(TreeLinkNode root) {
    	Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		if(root == null) return;
		queue.add(root);
		while(!queue.isEmpty()){
			TreeLinkNode node = queue.poll();
			if(node.left != null){
				queue.add(node.left);
				if(node.right!= null)
				   node.left.next = node.right;
				else
				   node.left.next = findNextNode(node.next);
			}
			if(node.right != null){
				queue.add(node.right);
				node.right.next= findNextNode(node.next);
			}
		}		
    }
    
    private TreeLinkNode findNextNode(TreeLinkNode node){
		if(node != null){
			if(node.left != null) return node.left;
			else if(node.right != null) return node.right;
			else{
				return findNextNode(node.next);
			}
		}
		return null;   	
    }
}
