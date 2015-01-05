/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode p=new ListNode(-1);
        p.next=head;
        ListNode start=p;
        int toCompareNum=head.val;
        while(head.next!=null){
            if(head.next.val!=toCompareNum){
                if(start.next!=head)
                    start.next=head.next;
                else
                    start=head;
            }
            head=head.next;
            toCompareNum=head.val;
        }
        if(start.next!=head){
            start.next=head.next;
        }
        return p.next;
    }
}
