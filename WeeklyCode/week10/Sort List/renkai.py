class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def merge(self, first, second):
        newhead = ListNode(0)
        head = newhead
        while first and second:
            if first.val < second.val:
                newhead.next = first
                first = first.next
            else:
                newhead.next = second
                second = second.next
            newhead = newhead.next
        if first: newhead.next = first
        if second: newhead.next = second
        return head.next
            
    def sortList(self, head):
        if head == None: return None
        if head.next == None: return head
        fast = head; slow = head;
        while fast:
            if fast.next: fast = fast.next.next
            else: break
            if not fast: break
            slow = slow.next
        second = self.sortList(slow.next)
        slow.next = None
        first = self.sortList(head)
        return self.merge(first, second)