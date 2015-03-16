class Solution:
    # @param root, a tree node
    # @return a boolean
    def heightBalanced(self, root):
        if root == None:
            return 0,True
        lheight, lbalanced = self.heightBalanced(root.left)
        rheight, rbalanced = self.heightBalanced(root.right)
        if not (lbalanced and rbalanced) or abs(lheight - rheight) > 1:
            return -1, False
        else:
            return max(lheight, rheight) + 1, True
        
    def isBalanced(self, root):
        height, balanced = self.heightBalanced(root)
        return balanced