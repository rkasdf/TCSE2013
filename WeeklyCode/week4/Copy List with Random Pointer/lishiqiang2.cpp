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
        map<RandomListNode *,RandomListNode *> map;
        RandomListNode *iHead=new RandomListNode(-1),*cpy=iHead,*org=head;
        while(org){
            cpy->next=map.count(org)?map[org]:new RandomListNode(org->label);
            map[org]=cpy->next;
            cpy->next->random=org->random?(map.count(org->random)?map[org->random]:new RandomListNode(org->random->label)):NULL;
            map[org->random]=cpy->next->random;
            cpy=cpy->next;
            org=org->next;
        }
        return iHead->next;
    }
};