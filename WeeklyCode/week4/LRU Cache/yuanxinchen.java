package org.leetcode.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.KeySelector.Purpose;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LRUCache {
	class CacheNode {
		int key;
		int value;
		CacheNode prev;
		CacheNode next;

		public CacheNode(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public CacheNode() {
		}
	}

	private CacheNode tail;
	private CacheNode head;
	private int size;
	private int capacity;
	private Map<Integer, CacheNode> map;

	private LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<>();
	}

	// remove the given node from the linked list
	private void remove(CacheNode removeNode) {
		// update the previous node
		if (removeNode.prev != null) {
			removeNode.prev.next = removeNode.next;
		} else { // it is the head
			head = removeNode.next;
		}
		// update the next node
		if (removeNode.next != null) {
			removeNode.next.prev = removeNode.prev;
		} else {// it is the tail
			tail = removeNode.prev;
		}
		size--;
	}

	// put the given node into the head
	private void put(CacheNode putNode) {
		if (head != null) {
			head.prev = putNode;
		} else {// the given node is the first node in the linked list
			tail = putNode;
		}
		putNode.next = head;
		putNode.prev = null;
		head = putNode;
		size++;
	}

	public int get(int key) {
		CacheNode result = map.get(key);
		if (result == null) {
			return -1;
		}
		remove(result);
		put(result);
		return result.value;
	}

	private boolean isSpaceAvailable() {
		if (size >= capacity) {
			return false;
		} else {
			return true;
		}
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			CacheNode result = map.get(key);
			result.value = value;
			remove(result);
			put(result);
		} else {
			if (isSpaceAvailable()) {
				CacheNode node = new CacheNode(key, value);
				put(node);
				map.put(key, node);
			} else {
				map.remove(tail.key);
				CacheNode node = tail;
				node.key = key;
				node.value = value;
				remove(node);
				put(node);
				map.put(key, node);
			}
		}
	}

	public LRUCache() {

	}

	@Test
	public void test1() {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		assertEquals(1, cache.get(2));
		cache.set(3, 2);
		assertEquals(-1, cache.get(2));
		assertEquals(2, cache.get(3));
	}

	@Test
	public void test2() {
		LRUCache cache = new LRUCache(2);
		cache.set(2, 1);
		cache.set(1, 1);
		assertEquals(1, cache.get(2));
		cache.set(4, 1);
		assertEquals(-1, cache.get(1));
		assertEquals(1, cache.get(2));
	}

	@Test
	public void test3() {
		LRUCache cache = new LRUCache(1);
		cache.set(2, 1);
		assertEquals(1, cache.get(2));
	}
}
