public class LRUCache {
    private int capacity;
    private int count;
    private Map<Integer, ListNode> index;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        index = new HashMap<Integer, ListNode>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = index.get(key);
        if (node != null) {
            shiftToFirst(node);
            return node.value;
        }
        return -1;
    }


    public void set(int key, int value) {
        ListNode node = index.get(key);
        if (node != null) {
            shiftToFirst(node);
            node.value = value;
        } else {
            ListNode newNode = new ListNode(key, value);
            if (count == capacity)
                removeLast();
            else
                count++;
            insertFirst(newNode);
            index.put(key, newNode);
        }
    }

    private void shiftToFirst(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        insertFirst(node);
    }

    private void insertFirst(ListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeLast() {
        index.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}

class ListNode {
    int key;
    int value;
    ListNode prev;
    ListNode next;

    ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
