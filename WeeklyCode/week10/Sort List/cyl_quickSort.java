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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode left = new ListNode(-1),p1 = left;
        ListNode right = new ListNode(-1),p2 = right;
        ListNode mid = new ListNode(-1),p3 = mid;
        ListNode p = head;
        while(p!=null){
            if(p.val<head.val){
                p1.next = p;
                p1 = p1.next;
            }else if(p.val>head.val){
                p2.next = p;
                p2 = p2.next;
            }else{
                p3.next = p;
                p3 = p3.next;
            }
            p = p.next;
            p1.next = p2.next = null;
        }
        
        left = sortList(left.next);
        right = sortList(right.next);
        ListNode h = new ListNode(-1);
        p = h;p.next = left;
        if(left!=null){
            while(left.next!=null){
                left = left.next;
            }
            p = left;
        }
        p.next = mid.next;
        p3.next = right;
        return h.next;
    }
}
