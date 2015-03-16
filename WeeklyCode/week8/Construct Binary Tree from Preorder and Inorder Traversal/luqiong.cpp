class Solution {
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder) {
        return buildTree(begin(preorder),end(preorder),begin(inorder),end(inorder));
    }
    template<typename InputIterator>
    TreeNode *buildTree(InputIterator pre_first, InputIterator pre_last, InputIterator in_first, InputIterator in_last){
        if(pre_first == pre_last || in_first == in_last)return NULL;
        auto i = find(in_first, in_last, *pre_first);
        auto j = distance(in_first, i);
        TreeNode *root = new TreeNode(*pre_first);
        root->left = buildTree(next(pre_first), next(pre_first,j+1), in_first, next(in_first,j));
        root->right = buildTree(next(pre_first,j+1), pre_last, next(in_first,j+1), in_last);
        return root;
    }
};