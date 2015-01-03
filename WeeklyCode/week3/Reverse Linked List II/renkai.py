__author__ = 'kai'
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param m, an integer
    # @param n, an integer
    # @return a ListNode
    def reverseBetween(self, head, m, n):
        if m == n:
            return head
        newnode = ListNode(0)
        newnode.next = head
        nodem_prev = newnode
        for i in range(0, m-1):
            nodem_prev = nodem_prev.next
        prev = nodem_prev.next
        for i in range(m, n):
            cur = prev.next
            prev.next = cur.next
            cur.next = nodem_prev.next
            nodem_prev.next = cur
        return newnode.next