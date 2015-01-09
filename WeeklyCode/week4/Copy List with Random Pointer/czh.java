package week4;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
		RandomListNode dummy = new RandomListNode(-1);
		RandomListNode preNewNode = dummy;
		RandomListNode oldNode = head;
		while(oldNode != null){
			RandomListNode tmp = oldNode.next;
			map.put(oldNode, oldNode.next);
			RandomListNode node = new RandomListNode(oldNode.label);
			node.random = oldNode;
			preNewNode.next = node;
			oldNode.next = node;
			preNewNode = node;
			oldNode = tmp;
		}
		RandomListNode newNode = dummy.next;
		while(newNode != null){
			if(newNode.random.random != null)
			   newNode.random =newNode.random.random.next;
			else {
				newNode.random = null;
			}
			newNode = newNode.next;
		}
		oldNode = head;
		for(int i=0; i< map.size();i++){
			oldNode.next = map.get(oldNode);
			oldNode = oldNode.next;
		}
		return dummy.next;
        
    }
}
