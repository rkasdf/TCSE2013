/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) {
        if(!head){ //如果链表为空
            return NULL;
        }else if(!head->next){ //如果链表只有一个节点
            return new TreeNode(head->val);
        }else{ //如果链表有两个及以上几点
           ListNode *preMid=findPreMid(head); //找到head的中点之前的一个节点；
           ListNode *mid=preMid->next;
           preMid->next=NULL;
           TreeNode *left=sortedListToBST(head);
           TreeNode *right=sortedListToBST(mid->next);
           TreeNode *root=new TreeNode(mid->val);
           root->left=left;
           root->right=right;
           return root;
        }
    }
    ListNode * findPreMid(ListNode *head){
        ListNode *preHead=new ListNode(0),*fast=preHead,*slow=preHead,*preMid;
        preHead->next=head;
        while(fast&&fast->next){
            fast=fast->next->next;
            preMid=slow;
            slow=slow->next;
        }
        preMid=fast?preMid->next:preMid;
        return preMid;
    }
};