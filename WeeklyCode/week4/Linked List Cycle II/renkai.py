__author__ = 'inferno'
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a list node
    def detectCycle(self, head):
        if head == None or head.next == None:
            return None
        fast = head
        slow = head
        while fast and slow:
            slow = slow.next
            fast = fast.next.next if fast.next else None
            if fast == slow:
                break
        if fast == None or slow == None:
            return None
        slow2 = head
        while slow2 != slow:
            slow = slow.next
            slow2 = slow2.next
        return slow
