public class LRUCache {
    
	private int capacity;
	private int currentSize;
	private ListNode head;
	private ListNode tail;
	
	private HashMap <Integer, ListNode> map = new HashMap<Integer, ListNode>();
    public LRUCache(int capacity) {
    	this.capacity = capacity;
    	this.currentSize = 0;
    }
    
    public int get(int key) {
    	ListNode node = map.get(key);
        if (node != null) {
        	moveToHead(node);
        	return node.val;
        }
        else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
        	if (currentSize >= capacity) {
        		remove(tail);
        	}
        	else {
        		currentSize++;
        	}
        	node = new ListNode(key, value);
        	map.put(key, node);
        	moveToHead(node);
        }
        else {
        	node.val = value;
        	moveToHead(node);
        }
    }
    
    public void moveToHead(ListNode node) {
    	if (node == head) 
    		return;
    	if (node.pre != null)
    		node.pre.next = node.next;
    	if (node.next != null)
    		node.next.pre = node.pre;
    	if (node == tail)
    		tail = node.pre;
    	if (head != null) {
    	    head.pre = node;
    	}
    	node.next = head;
    	node.pre = null;
    	head = node;
    	if (tail == null) {
    	    tail = head;
    	}
    }
    
    public void remove(ListNode node){
    	if (node == head) {
    		head = node.next;
    	}
    	if (node == tail) {
    		tail = node.pre;
    	}
    	if (node.pre != null)
    		node.pre.next = node.next;
    	if (node.next != null)
    		node.next.pre = node.pre;
    	map.remove(node.key);
    }
    
    class ListNode {
        int key;
    	int val;
    	ListNode pre;
    	ListNode next;
    	public ListNode(int key, int val){
    	    this.key = key;
    		this.val = val;
    	}
    }
}
