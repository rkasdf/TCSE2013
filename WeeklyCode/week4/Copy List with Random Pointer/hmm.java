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
        List<RandomListNode> nodeList = new ArrayList<RandomListNode>();
        List<RandomListNode> originalNodeList = new ArrayList<RandomListNode>();
        RandomListNode curNode = head;
        while(curNode != null){
            RandomListNode node = new RandomListNode(curNode.label);
            nodeList.add(node);
            originalNodeList.add(curNode);
            curNode = curNode.next;
        }
        for(int i=0;i<originalNodeList.size();i++){
            RandomListNode oldNode = originalNodeList.get(i);
            RandomListNode newNode = nodeList.get(i);
            if(oldNode.next != null){
                newNode.next = nodeList.get(i+1);
            }
            if(oldNode.random != null){
                newNode.random = nodeList.get(originalNodeList.indexOf(oldNode.random));
            }
        }
        return nodeList.isEmpty() ? null : nodeList.get(0);
    }
}