public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode nextRight = null, head=root, preRight = null, parent=null;
        while(nextRight != null || head != null){
			if(nextRight == null){
				parent = head;
				head = null;
				preRight = null;
			}else{
				parent = nextRight;
			}
            if(parent.left != null){
                head = head == null?parent.left:head;
                if(preRight != null){
                    preRight.next = parent.left;
                }
                preRight = parent.left;
            }
			if(parent.right != null){
                head = head == null?parent.right:head;
                if(preRight != null){
                    preRight.next = parent.right;
                }
                preRight = parent.right;
            }
			
            nextRight=parent.next;
        }
    }
}