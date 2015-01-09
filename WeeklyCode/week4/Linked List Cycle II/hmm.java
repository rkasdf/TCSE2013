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
      private int countCycle(ListNode twoStep, ListNode oneStep){
	        int count = 0;
	        while(true){
	            oneStep = oneStep.next;
	            count ++;
	            if(oneStep.equals(twoStep)){
	                break;
	            }
	        }
	        return count;
	    }
	    private ListNode getStartNode(ListNode head, int cycle){
	        if(cycle == 0) return null;
	        ListNode curNode = head, nextNode = null;
	        while(true){
	        	nextNode = curNode;
	            for(int i=0;i<cycle;i++){
	                nextNode = nextNode.next;
	            }
	            if(curNode.equals(nextNode)) return curNode;
	            curNode = curNode.next;
	        }
	    }
	    public ListNode detectCycle(ListNode head) {
	        if(head == null || head.next == null) return null;
	        ListNode oneStep = head, twoStep = head.next;
	        while(oneStep != null && twoStep != null){
	            if(oneStep.equals(twoStep)){
	                return getStartNode(head, countCycle(twoStep, oneStep));
	            }
	            oneStep = oneStep.next;
	            twoStep = twoStep.next == null ? null:twoStep.next.next;
	        }
	        return null;
	    }
}