__author__ = 'inferno'
class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        node = head
        while node:
            newnode = RandomListNode(node.label)
            newnode.next = node.next
            node.next = newnode
            node = newnode.next
        node = head
        while node:
            if node.random:
                node.next.random = node.random.next
            node = node.next.next
        newhead = RandomListNode(0)
        newnode = newhead
        node = head
        while node:
            newnode.next = node.next
            node.next = node.next.next if node.next else None
            newnode = newnode.next
            node = node.next
        return newhead.next
