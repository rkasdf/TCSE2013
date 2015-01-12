class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        RandomListNode *cur = head;
        while(cur){
            RandomListNode *dup = new RandomListNode(cur->label);
            dup->next = cur->next;
            cur->next = dup;
            cur = dup->next;
        }
        cur = head;
        while(cur){
            if(cur->random){
                cur->next->random = cur->random->next;
            }
            cur = cur->next->next;
        }
        RandomListNode head2(0);
        RandomListNode *new_cur = &head2;
        cur = head;
        while(cur){
            new_cur->next = cur->next;
            cur->next = cur->next->next;
            cur = cur->next;
            new_cur = new_cur->next;
        }
        return head2.next;
    }
};