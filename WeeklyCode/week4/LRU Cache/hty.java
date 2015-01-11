package iscas.leetcode.hty.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hty on 2015/1/10.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
 * get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {
    private Map<Integer, DoubleLinkNode> map = new HashMap<Integer, DoubleLinkNode>();
    private DoubleLinkNode head;
    private DoubleLinkNode tail;
    private int capacity;
    private int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {
        if (this.map.containsKey(key))
            return operate(this.map, key).val;
        else
            return -1;
    }

    public void set(int key, int value) {
        if (this.map.containsKey(key))
            operate(this.map, key).val = value;
        else {
            DoubleLinkNode node = new DoubleLinkNode(key, value);

            setHeadNode(node);
            this.map.put(key, node);

            if (this.count < this.capacity)
                this.count++;
            else {
                this.map.remove(this.tail.key);
                removeNode(this.tail);
            }

        }
    }

    private DoubleLinkNode operate(Map<Integer, DoubleLinkNode> map, int key) {
        DoubleLinkNode newNode = map.get(key);
        /*if (!removeNode(newNode) && setHeadNode(newNode)) //懒得去写了
            return new DoubleLinkNode(MAX);*/
        removeNode(newNode);
        setHeadNode(newNode);
        return newNode;
    }

    private boolean removeNode(DoubleLinkNode node) {
        try {
            if (node.prev != null)
                node.prev.next = node.next;
            else
                this.head = node.next;

            if (node.next != null)
                node.next.prev = node.prev;
            else
                this.tail = node.prev;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean setHeadNode(DoubleLinkNode node) {
        try {
            node.next = this.head;
            node.prev = null;

            if (this.head != null)
                this.head.prev = node;
            this.head = node;

            if (this.tail == null)
                this.tail = node;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    class DoubleLinkNode {
        int key;
        int val;
        DoubleLinkNode prev;
        DoubleLinkNode next;

        public DoubleLinkNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

}
