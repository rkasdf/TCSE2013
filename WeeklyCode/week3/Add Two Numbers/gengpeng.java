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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        int num = 0;
        ListNode head = l1;
        while(l1!=null&&l2!=null){
            tmp = (l1.val+l2.val+tmp)/10;
            l1.val = (l1.val+l2.val+num)%10;
            num = tmp;
            if(l1.next!=null){
                l1 = l1.next;
            }
            l2 = l2.next;
        }
        if(l2!=null){
            l1.next = l2;
        }
        while(l2!=null){
            tmp = (l2.val+tmp)/10;
            l2.val = (l2.val+num)%10;
            num = tmp;
            l2 = l2.next;
            
        }
        
        if(num!=0){
            ListNode ln = new ListNode(tmp);
            l1.next = ln;
        }
       
        return head;
    }
}