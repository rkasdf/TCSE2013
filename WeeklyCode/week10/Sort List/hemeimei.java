public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fast = head,slow = head;
        while(fast.next != null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return merge2List(sortList(fast), sortList(head));
    }
    private ListNode merge2List(ListNode listNode1, ListNode listNode2){
        ListNode vHead = new ListNode(-1),it1 = vHead,temp;
        vHead.next = listNode1;
        while(it1.next != null && listNode2 != null){
            if(it1.next.val > listNode2.val){
                temp = listNode2.next;
                listNode2.next = it1.next;
                it1.next = listNode2;
                listNode2 = temp;
            }else{
                it1 = it1.next;
            } 
        }
        if(listNode2 != null){
            it1.next = listNode2;
        }
        return vHead.next;
    }
}