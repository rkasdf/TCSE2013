package org.leetcode.main;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListwithRandomPointer {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Map<String, String> map = new HashMap<>();
		map.get(null);
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		Map<RandomListNode, RandomListNode> existMap = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode curNode = head;
		RandomListNode copy= null, copyCurNode = null;
		if(head != null) {
			copy = new RandomListNode(head.label);
			copy.next = null;
			copy.random = null;
			copyCurNode = copy;
		}
		while(curNode != null) {
			RandomListNode nextNode = null;
			RandomListNode randomNode = null;
			if(curNode.next != null && !existMap.containsKey(curNode.next)) {
				nextNode = new RandomListNode(curNode.next.label);
				existMap.put(nextNode, nextNode);
				copyCurNode.next = nextNode;
			} else {
				copyCurNode.next = existMap.get(curNode.next);
			}
			if(curNode.random != null && !existMap.containsKey(curNode.random)) {
				randomNode = new RandomListNode(curNode.random.label);
				existMap.put(randomNode, randomNode);
				copyCurNode.random = randomNode;
			} else {
				copyCurNode.random = existMap.get(curNode.random);
			}
			copyCurNode = copyCurNode.next;
			curNode = curNode.next;
		}
		return copy;
	}
}
