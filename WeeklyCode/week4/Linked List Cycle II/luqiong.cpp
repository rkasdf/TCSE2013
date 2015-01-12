class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *slow=head, *fast=head;
        while(fast && fast->next){
            fast = fast->next->next;
            slow = slow->next;
            if(fast == slow){
                fast = head;
                while(slow != fast){
                    slow = slow->next;
                    fast = fast->next;
                }
                return slow;
            }
        }
        return NULL;
    }
};