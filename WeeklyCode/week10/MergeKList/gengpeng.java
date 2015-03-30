public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        Queue<ListNode> queue = new LinkedList<ListNode>(lists);
        while(!queue.isEmpty()){
            ListNode first = queue.poll();
            ListNode second = queue.poll();
            if(queue.isEmpty()) 
                return merge(first,second);
            queue.offer(merge(first,second));
        }
        return null;
    }
    
    private ListNode merge(ListNode one, ListNode two){
        if(one==null) return two;
        if(two==null) return one;
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(one!=null&&two!=null){
            if(one.val<two.val){
                head.next = one;
                one = one.next;
                head = head.next;
            }else{
                head.next = two;
                two = two.next;
                head = head.next;
            }
        }
        if(one!=null) head.next = one;
        if(two!=null) head.next = two;
        return result.next;
    }
}