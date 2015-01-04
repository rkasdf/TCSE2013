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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pCur = head;
        ListNode pHead = null;
        ListNode pNext = null;
        ListNode pre = null; 
        
        for(int i=1;i<m;i++){
            pHead = pCur;
            pCur = pCur.next;
        }
        
        pre = pCur;
        pNext = pCur.next;
        
        for(int j=m;j<n;j++){
            ListNode tmp = pNext.next;
            pNext.next = pCur;
            pCur = pNext;
            pNext = tmp;
        }
        
        pre.next = pNext;
        
        if(pHead!=null){
            pHead.next = pCur;
        }else{
            head = pCur;
        }
        
        return head;
    }
}