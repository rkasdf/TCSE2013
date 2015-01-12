/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode headNode=new ListNode(-1);
        headNode.next=head;
        ListNode slow=headNode;
        ListNode fast=headNode;
        while(fast!=null && fast.next!=null && slow!=null){
            if(fast==slow && fast!=headNode){
                ListNode begin=headNode;
                while(begin!=slow){
                    begin=begin.next;
                    slow=slow.next;
                }
                return begin;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return null;
    }
}
