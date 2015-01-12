/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
    		return head;
    	}
    	//step1
    	RandomListNode currNode = head;
    	while(currNode!=null){
    		RandomListNode copyNode = new RandomListNode(currNode.label);
    		copyNode.next = currNode.next;
    		currNode.next = copyNode;
    		copyNode.random = currNode.random;
    		if(currNode.next.next != null){
    			currNode = currNode.next.next;
    		}else{
    			break;
    		}
    	}
    	//step2
    	currNode = head;
    	while(currNode != null){
    		if(currNode.random != null && currNode.next != null){
    			currNode.next.random = currNode.random.next;
    		}
    		if(currNode.next.next != null){
    			currNode = currNode.next.next;
    		}else{
    			break;
    		}
    	}
    	//step3
    	currNode = head;
    	RandomListNode newListHead = new RandomListNode(-1);
    	newListHead.next = head.next;
    	RandomListNode newListCurrNode = head.next;
    	while(currNode!=null && newListCurrNode!=null){
    		currNode.next = newListCurrNode.next;
    		if(currNode.next != null){
    			newListCurrNode.next = currNode.next.next;
    		}else{
    			break;
    		}
    		currNode = currNode.next;
    		newListCurrNode = newListCurrNode.next;
    	}
    	//result
        return newListHead.next;
    }
}