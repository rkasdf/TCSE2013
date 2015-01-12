/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *fast,*slow,*new_slow;
        fast=slow=head;
        while(slow&&fast&&fast->next){
            slow=slow->next;
            fast=fast->next->next;
            if(fast==slow){
                new_slow=head;
                while(new_slow!=slow){
                    slow=slow->next;
                    new_slow=new_slow->next;
                }
                return new_slow;
            }
        }
        return NULL;
    }
};