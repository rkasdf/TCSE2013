# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param a list of ListNode
    # @return a ListNode
    def mergeKLists(self, lists):
        heap = []
        for node in lists:
            if node:
                heap.append((node.val, node))
        head = ListNode(0); cur = head
        heapq.heapify(heap)
        while heap:
            node = heapq.heappop(heap)
            cur.next = node[1]
            cur = cur.next
            if cur.next:
                heapq.heappush(heap, (cur.next.val, cur.next))
        return head.next