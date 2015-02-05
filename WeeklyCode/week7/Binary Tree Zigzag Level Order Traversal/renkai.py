# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def insertintolist(self, root, res, level):
        if root:
            if len(res) < level + 1: res.append([])
            if level % 2: res[level].insert(0, root.val)
            else: res[level].append(root.val)
            self.insertintolist(root.left, res, level+1)
            self.insertintolist(root.right, res, level+1)
    def zigzagLevelOrder(self, root):
        res = []
        self.insertintolist(root, res, 0)
        return res