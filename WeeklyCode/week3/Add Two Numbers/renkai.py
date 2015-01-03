__author__ = 'kai'
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        carry = 0
        digit = ListNode(0)
        head = digit
        while l1 != None or l2 != None:
            node = ListNode(0)
            digit.next = node
            digit = digit.next
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            digit.val = val1 + val2 + carry
            if digit.val >= 10:
                digit.val -= 10 
                carry = 1
            else:
                carry = 0
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        if carry == 1:
            node = ListNode(carry)
            digit.next = node
        return head.next