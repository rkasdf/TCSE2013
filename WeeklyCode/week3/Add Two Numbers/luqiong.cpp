class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        if(!l1)return l2;
        if(!l2)return l1;
        int flag = 0;
        int tmp = 0;
        ListNode l3(0);	//head node
        ListNode *p = &l3;
        while(l1 || l2){
            if(l1)tmp += l1->val;
            if(l2)tmp += l2->val;
            tmp += flag;
            flag = tmp/10;
            p->next = new ListNode(tmp%10);	//rear insert
			p = p->next;
            if(l1)l1 = l1->next;
            if(l2)l2 = l2->next;
            tmp = 0;
        }
        if(flag != 0)p->next = new ListNode(flag);	//last carry
        return l3.next;
    }
};