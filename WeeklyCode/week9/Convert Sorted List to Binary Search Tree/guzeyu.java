public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
		if(head == null){
			return null;
		}
		int count = 0;
		ListNode curr = head;
		while(curr != null){
			curr = curr.next;
			count++;
		}
		ListNode currHead = head;
		return helper(currHead,1,count);
		
    }
	
	public TreeNode helper(ListNode currHead,int l,int r){
		if(l>r){
			return null;
		}
		int m = (l+r)/2;
		TreeNode left = helper(currHead, l, m-1);
		ListNode currMid = currHead;
		for(int i=l;i<m;i++){
			currMid = currMid.next;
		}
		TreeNode right = helper(currMid.next, m+1, r);
		TreeNode root = new TreeNode(currMid.val);
		root.left = left;
		root.right = right;
		return root;
	}
}