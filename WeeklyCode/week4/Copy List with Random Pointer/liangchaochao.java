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
        if(head==null) return null;
        HashMap<RandomListNode,RandomListNode> stores=new HashMap<>();
        RandomListNode p=new RandomListNode(-1);
        p.next=head;
        RandomListNode q=new RandomListNode(-1);
        RandomListNode resultHead=q;
        while(p.next!=null){
            q.next=getRandomListNode(stores,p.next);
            q.next.random=getRandomListNode(stores,p.next.random);
            p=p.next;
            q=q.next;
        }
        return resultHead.next;
    }
    public RandomListNode getRandomListNode(Map<RandomListNode,RandomListNode> stores,RandomListNode key){
        if(key==null) return null;
        RandomListNode randomNode=stores.get(key);
        if(randomNode==null){
            randomNode=new RandomListNode(key.label);
            stores.put(key,randomNode);
        }
        return randomNode;
    }
}
