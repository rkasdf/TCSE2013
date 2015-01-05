class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if(!head)return NULL;
        ListNode *pre = head;
        ListNode *cur = head->next;
        while(cur)
        {
            if(cur->val == pre->val)
                pre->next = cur->next;
            else
                pre = cur;
            cur = cur->next;
        }
        return head;
    }
};