class Solution:
    # @return a list of tree node
    def dfs(self, start, end):
        if start > end: return [None]
        res = []
        for i in range(start, end+1):
            left = self.dfs(start, i-1)
            right = self.dfs(i+1, end)
            for leftnode in left:
                for rightnode in right:
                    root = TreeNode(i)
                    root.left = leftnode
                    root.right = rightnode
                    res.append(root)
        return res
    def generateTrees(self, n):
        return self.dfs(1,n)