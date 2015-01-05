public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
		ListNode currNode = head, startNode = null, endNode = null, topNode = null, tempNode;
		for (int i = 1; i <= n; i++) {
			if (i == (m - 1)) {
				startNode = currNode;
				currNode = currNode.next;
			} else if (i >= m) {
				tempNode = currNode;
				currNode = currNode.next;
				tempNode.next = topNode;
				topNode = tempNode;
				if (i == m) {
					endNode = tempNode;
				}else if (i == n) {
					endNode.next = currNode;//this currNode is the next of nth node
					if (startNode != null){
						startNode.next = topNode;
					}else{
						head = topNode;
					}
				}
			} else {
				currNode = currNode.next;
			}
		}
		return head;
	}
}