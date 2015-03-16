class Solution {
public:
    void connect(TreeLinkNode *root) {
        if(!root)return ;
        TreeLinkNode *tmp = new TreeLinkNode(0);
        TreeLinkNode *pre = tmp;
        TreeLinkNode *cur = root;
        while(cur){
            if(cur->left){
                pre->next = cur->left;
                pre = pre->next;
            }
            if(cur->right){
                pre->next = cur->right;
                pre = pre->next;
            }
            cur = cur->next;
        }
        connect(tmp->next);
    }
};