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
        if(head == null) 
        	return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode resultListHead = new RandomListNode(head.label);
        map.put(head,resultListHead);
        
        RandomListNode currNode = head;
        RandomListNode resultListCurrNode = resultListHead;
        while(currNode != null){
            if(!map.containsKey(currNode)){
                RandomListNode tmp = new RandomListNode(currNode.label);
                map.put(currNode,tmp);
            } 
            if(currNode.next != null && !map.containsKey(currNode.next)){
                RandomListNode next = new RandomListNode(currNode.next.label);
                map.put(currNode.next,next);
                resultListCurrNode.next = next;
            }
            else if(currNode.next != null){
                resultListCurrNode.next = map.get(currNode.next);
            }
            
            if(currNode.random != null && !map.containsKey(currNode.random)){
                RandomListNode random = new RandomListNode(currNode.random.label);
                map.put(currNode.random,random);
                resultListCurrNode.random = random;
            }
            else if(currNode.random != null){
                resultListCurrNode.random = map.get(currNode.random);
            }
            
            currNode = currNode.next;
            resultListCurrNode = resultListCurrNode.next;
        }
        return resultListHead;
    }
}