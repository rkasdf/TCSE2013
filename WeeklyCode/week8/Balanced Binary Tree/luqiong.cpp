int getHeight(TreeNode *root)
{
	if(!root)return 0;
	int left = getHeight(root->left);
	int right = getHeight(root->right);
	if(left<0 || right<0 || abs(right-left)>1)
		return -1;
	return max(left,right)+1;
}
bool isBalanced(TreeNode *root) {
	if(getHeight(root)!=-1)
		return true;
	else
		return false;
}