__author__ = 'inferno'
class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.pre = None
        self.next = None
class LRUCache:

    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.curcapac = 0
        self.head = ListNode(-1, -1)
        self.tail = ListNode(-1, -1)
        self.head.next = self.tail
        self.tail.pre = self.head
        self.nodemap = { }
    # @return an integer
    def __changeseq(self, node):
        if node != self.head.next:
            node.pre.next = node.next
            node.next.pre = node.pre
            self.head.next.pre = node
            node.next = self.head.next
            self.head.next = node
    def get(self, key):
        if self.nodemap.has_key(key):
            node = self.nodemap.get(key)
            self.__changeseq(node)
            return node.value
        else:
            return -1

    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if self.capacity == 0:
            return None
        if self.nodemap.has_key(key):
            self.__changeseq(self.nodemap.get(key))
            self.nodemap[key].value = value
        else:
            if self.curcapac < self.capacity:
                self.curcapac += 1
            else:
                del self.nodemap[self.tail.pre.key]
                self.tail.pre = self.tail.pre.pre
                self.tail.pre.next = self.tail
            newnode = ListNode(key, value)
            self.nodemap[key] = newnode
            newnode.pre = self.head
            newnode.next = self.head.next
            newnode.next.pre = newnode
            self.head.next = newnode