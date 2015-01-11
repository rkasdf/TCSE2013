package iscas.leetcode.hty.copylist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hty on 2015/1/10.
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode prototype = head;
        RandomListNode node = cloneNode(prototype);
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(prototype, node);

        while (node != null) {
            if (assignment(prototype.next, map, node, true) && assignment(prototype.random, map, node, false)) {
                node = node.next;
                prototype = prototype.next;
            } else {
//              throw new Exception("");
                break;
            }
        }
        return map.get(head);
    }

    private RandomListNode cloneNode(RandomListNode prototype) {
        RandomListNode node = new RandomListNode(prototype.label);
        node.next = prototype.next;
        node.random = prototype.random;
        return node;
    }

    private boolean assignment(RandomListNode prototype, Map<RandomListNode, RandomListNode> map, RandomListNode assign, boolean type) {
        try {
            if (prototype != null) {
                if (!map.containsKey(prototype)) {
                    RandomListNode node = cloneNode(prototype);
                    if (type)
                        assign.next = node;
                    else
                        assign.random = node;
                    map.put(prototype, node);
                } else {
                    if (type)
                        assign.next = map.get(prototype);
                    else
                        assign.random = map.get(prototype);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
