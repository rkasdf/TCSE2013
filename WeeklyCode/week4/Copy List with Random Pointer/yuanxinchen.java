public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for(RandomListNode curr = head; curr != null; curr = curr.next) {
		RandomListNode node = new RandomListNode(curr.label);
		map.put(curr, node);
        }
        for(RandomListNode curr = head; curr != null; curr = curr.next) {
		RandomListNode node = map.get(curr);
		node.next = map.get(curr.next);
		node.random = map.get(curr.random);
        }
        return map.get(head);
    }
}
