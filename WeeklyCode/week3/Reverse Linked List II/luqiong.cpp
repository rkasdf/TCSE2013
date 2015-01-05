class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) {
        if(!head)return head;
        ListNode head2(0);
        ListNode *pre;
        ListNode *first;
        ListNode *cur;
        head2.next = head;
        pre = &head2;
        for(int i=1;i<m;i++)pre = pre->next;
        first = pre->next;
        cur = first->next;
        for(int i=m;i<n;i++){
            first->next = cur->next;
            cur->next = pre->next;
            pre->next = cur;
            cur = first->next;
        }
        return head2.next;
    }
};