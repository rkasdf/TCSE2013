public class Solution {
    private ListNode list;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = 0;
        ListNode curNode = head;
        while(curNode != null){
            len++;
            curNode = curNode.next;
        }
        list = head;
        return sortedListToBST(0, len-1);
    }
    private TreeNode sortedListToBST(int start, int end){
        if(end < start){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode leftChild = sortedListToBST(start, mid-1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        TreeNode rightChild = sortedListToBST(mid+1, end);
        parent.right = rightChild;
        return parent;
    }
}