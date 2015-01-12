package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
		ListNode result = null;
		ListNode curNode = head;
		//using extra space
		Map<ListNode, Boolean> visitedMap = new HashMap<ListNode, Boolean>();
		while(curNode != null) {
			if(visitedMap.containsKey(curNode)) {
				return curNode;
			}
			visitedMap.put(curNode, true);
			curNode = curNode.next;
		}
		return result;
    }
    
    public boolean hasCycle(ListNode head) {
    		boolean result = false;
    		ListNode curNode = head;
    		//using extra space
    		Map<ListNode, Boolean> visitedMap = new HashMap<ListNode, Boolean>();
    		while(curNode != null) {
    			if(visitedMap.containsKey(curNode)) {
    				return true;
    			}
    			visitedMap.put(curNode, true);
    			curNode = curNode.next;
    		}
    		return result;
    }
    
    public ListNode detectCycleNoExtraSpace(ListNode head) {
    		ListNode slowNode = head, fastNode = head;
    		while(slowNode != null && fastNode != null && fastNode.next != null) {
    			slowNode = slowNode.next;
    			fastNode = fastNode.next.next;
    			if(fastNode == slowNode) {
    				ListNode result = head;
    				while(result != slowNode) {
    					slowNode = slowNode.next;
    					result = result.next;
    				}
    				return result;
    			}
    		}
    		return null;
    }
    
    @Test
    public void test() {
    		ListNode head = new ListNode(1);
    		head.next = new ListNode(2);
    		head.next.next = head;
    		assertNull(detectCycleNoExtraSpace(head));
    }
}
