# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a list node
    # @return a tree node
    def sortedArrayBST(self, array):
        length = len(array)
        if not length: return None
        mid = length / 2
        root = TreeNode(array[mid])
        if mid > 0: root.left = self.sortedArrayBST(array[0:mid])
        if mid < length-1: root.right = self.sortedArrayBST(array[mid + 1:])
        return root
    def sortedListToBST(self, head):
        array = []
        while head:
            array.append(head.val)
            head = head.next
        return self.sortedArrayBST(array)