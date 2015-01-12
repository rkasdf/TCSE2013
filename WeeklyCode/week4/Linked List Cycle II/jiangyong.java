/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
		if (head == null){
        	return null;
        }
        Set <ListNode>visit = new HashSet <ListNode>();
        ListNode p = head;
        while(p != null){
        	if (visit.contains(p)){
        		return p;
        	}
        	visit.add(p);
        	p = p.next;
        }
        return null;
	}
}
