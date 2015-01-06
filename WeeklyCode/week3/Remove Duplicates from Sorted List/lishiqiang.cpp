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
    ListNode *deleteDuplicates(ListNode *head) {
        ListNode *p1,*p2,*newHead=new ListNode(-1),*pre=newHead;
        newHead->next=p1=head;
        while(p1&&p1->next){
            p2=p1->next;
            while(p2&&p2->val==p1->val) p2=p2->next;
            pre->next=(p2==p1->next?p1:p2);
            pre=(p2==p1->next?p1:pre);
            p1=p2;
        }
        return newHead->next;
    }
};