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
	        if(head == null || head.next == null) return null;
	        ListNode oneStep = head, twoStep = head.next, anotherStep = head;
	        while(oneStep != null && twoStep != null){
	            if(oneStep.equals(twoStep)){
	                oneStep = oneStep.next;
	                while(!oneStep.equals(anotherStep)){
	                    oneStep = oneStep.next;
	                    anotherStep = anotherStep.next;
	                }
	                return oneStep;
	            }
	            oneStep = oneStep.next;
	            twoStep = twoStep.next == null ? null:twoStep.next.next;
	        }
	        return null;
	    }
}