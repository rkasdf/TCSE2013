public class Solution {
    private 	List<Integer> list = new ArrayList<Integer>();
   public TreeNode sortedListToBST(ListNode head) {
	  if(head == null) return null;
	  ListNode curNode = head;
	  while(curNode != null){
		  list.add(curNode.val);
		  curNode= curNode.next;
	  }
	  return dfs(0,list.size()-1);        
   }
   private TreeNode dfs(int left, int right) {
	   if(left > right) return null;
	   int mid = (right-left)/2+left;
	   int aa = list.get(mid);
	   TreeNode node = new TreeNode(aa);
	   node.left = dfs(left, mid-1);
	   node.right = dfs(mid+1, right);
	   return node;
   }
}