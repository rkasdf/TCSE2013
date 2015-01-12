/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *iHead=new RandomListNode(-1),*cpy,*org=head;
        while(org){
           cpy=new RandomListNode(org->label);
           cpy->next=org->next;
           org->next=cpy;
           org=cpy->next;
        }
        org=head;
        while(org){
            cpy=org->next;
            cpy->random=org->random?org->random->next:NULL;
            org=cpy->next;
        }
        org=head;
        cpy=iHead;
        while(org){
            cpy->next=org->next;
            cpy=cpy->next;
            org->next=cpy->next;
            org=org->next;
        }
        return iHead->next;
    }
};