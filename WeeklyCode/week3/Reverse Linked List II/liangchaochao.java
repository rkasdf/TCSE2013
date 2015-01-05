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
        ListNode p=new ListNode(-1);
        p.next=head;
        head=p;
        int index=1;
        ListNode m_node=null;
        while(p.next!=null){
            if(m==index){
                m_node=p;
            }
            if(index>m&&index<=n){
                ListNode temp1=m_node.next;
                ListNode temp2=p.next.next;
                m_node.next=p.next;
                p.next.next=temp1;
                p.next=temp2;
                index++;
                continue;
            }
            p=p.next;
            index++;
        }
        return head.next;
    }
}
