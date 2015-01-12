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
        RandomListNode newHead = new RandomListNode(head.label);
        newHead.next = head.next;
        head.next = newHead;
        RandomListNode newNode, p, q;
        for (p = head.next.next; p != null; p = p.next.next) {
            newNode= new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
        }
        for (p = head; p != null; p = p.next.next){
            if(p.random != null){
                p.next.random = p.random.next;
            }
        }
        for (p = head, q = newHead; p != null; p = p.next, q= q.next) {
            p.next = q.next;
            if (q.next != null){
                q.next = q.next.next;
            }
        }
        return newHead;
    }
}
