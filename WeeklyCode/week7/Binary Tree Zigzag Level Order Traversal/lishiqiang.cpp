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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        vector<vector<int> > result;
        deque<TreeNode *> queue;
        if(root) queue.push_back(root);
        bool flag=true;
        while(!queue.empty()){
            int size =queue.size();
            vector<int> level;
            for(int i=0;i<size;i++){
                 TreeNode *t = queue.front();
                 level.push_back(t->val);
                 if(t->left) queue.push_back(t->left);
                 if(t->right) queue.push_back(t->right);
                 queue.pop_front();
            }
            if(!flag) reverse(level.begin(),level.end());
            result.push_back(level);
            flag=!flag;
        }
        return result;
        
    }
};