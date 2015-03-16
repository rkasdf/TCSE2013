/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextRight = null, head=root, preRight = null, parent=null, child = null;
        while(nextRight != null || head != null){
			if(nextRight == null){
				parent = head;
				head = null;
				preRight = null;
			}else{
				parent = nextRight;
			}
			child = parent.left;
			for(int i=0;i<2;i++,child = parent.right){
                if(child != null){
                    head = head == null?child:head;
                    if(preRight != null){
                        preRight.next = child;
                    }
                    preRight = child;
                }
			}
            nextRight=parent.next;
        }
    }
}