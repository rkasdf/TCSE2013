package week4;

import week3.ListNode;

public class LinkedListCycleII {
	
	private ListNode move(ListNode node,int count) {
		while((count--)!=0){
			node = node.next;
		}
		return node;
	}	
	
	//O(n^2)
	public  ListNode detectCycle(ListNode head) {
		if(head == null) return null;
		ListNode single = head;
		ListNode node = null;
		ListNode dual = head;
		
		while(dual!=null && dual.next != null){
			single = single.next;
			dual = dual.next.next;
			if(single == dual){
				node = single;
				break;
			}
		}
		
		if(dual == null || dual.next == null){
			 return null;
		}
		
		ListNode curNode = node.next;
		int count = 1;
		while(curNode != node){
			count++;
			curNode=curNode.next;
		}
		
		curNode = head;
		while(curNode != move(curNode, count)){
			curNode = curNode.next;
		}
		return curNode;    
    }
	
	//O(n) 参考题解
	public static ListNode detectCycle2(ListNode head) {
		if(head == null) return null;
		ListNode single = head;
		ListNode dual = head;		
		while(dual!=null && dual.next != null){			
			single = single.next;
			dual = dual.next.next;
			if(single == dual){
				ListNode node = head;
				while(node != single){
					node = node.next;
					single = single.next;
				}
				return node;
			}
		}			
		return null ;    
    }
}
