class Solution:
    # @param preorder, a list of integers
    # @param inorder, a list of integers
    # @return a tree node
    def findindex(self, list, val):
        for i in range(len(list)):
            if list[i] == val:
                return i
        return -1
    def buildTree(self, preorder, inorder):
        if len(preorder) == 0:
            return None
        if len(preorder) == 1:
            return TreeNode(preorder[0])
        root = TreeNode(preorder[0])
        index = self.findindex(inorder, root.val)
        root.left = self.buildTree(preorder[1 : index + 1], inorder[0 : index])
        root.right = self.buildTree(preorder[index + 1 :], inorder[index + 1 :])
        return root