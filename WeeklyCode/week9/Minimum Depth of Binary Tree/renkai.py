class Solution:
    # @param root, a tree node
    # @return an integer
    def minDepth(self, root):
        if not root: return 0
        queue1 = [root]
        depth = 0
        while queue1:
            depth += 1
            queue2 = []
            for node in queue1:
                if not (node.left or node.right): return depth
                if node.left: queue2.append(node.left)
                if node.right: queue2.append(node.right)
            queue1 = queue2
            queue2 = []
        return depth