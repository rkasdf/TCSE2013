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
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode pNext = head;
        pre.next = head;
        ListNode pCur = pre;
        
        while(pNext!=null&&pNext.next!=null){
            if(pNext.val==pNext.next.val){
                while(pNext.next!=null&&pNext.val==pNext.next.val){
                    pNext = pNext.next;
                }
                pCur.next = pNext.next;
                pNext = pNext.next;
            }else{
                pCur = pCur.next;
                pNext = pNext.next;
            }
        }
        return pre.next;
        
    }
}