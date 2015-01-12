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
        if (head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newNode = newHead;
        map.put(head, newHead);
        for (RandomListNode p = head.next; p != null; p = p.next) {
            newNode.next = new RandomListNode(p.label);
            newNode = newNode.next;
            map.put(p, newNode);
        }
        for (RandomListNode p = head; p != null; p = p.next) {
            if (p.random != null) {
                 map.get(p).random = map.get(p.random);
            }
        }
        return newHead;
    }
}
