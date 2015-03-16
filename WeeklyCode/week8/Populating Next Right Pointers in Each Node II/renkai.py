class Solution:
    # @param root, a tree link node
    # @return nothing
    def findNextNode(self, root):
        while root:
            if root.left or root.right:
                return root.left if root.left else root.right
            root = root.next
        return None
    def connect(self, root):
        if root:
            if root.left and root.right:
                root.left.next = root.right
                root.right.next = self.findNextNode(root.next)
            else:
                firstNode = root.right if root.right else root.left
                if firstNode:
                    firstNode.next = self.findNextNode(root.next)
            self.connect(root.right)
            self.connect(root.left)