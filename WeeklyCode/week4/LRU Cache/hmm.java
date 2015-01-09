
public class LRUCache {
    int capacity;
	HashMap<Integer, ListNode> data = new HashMap<Integer, ListNode>();
	LRUList lruList = new LRUList();
	class ListNode{
		int key, val;
		ListNode after;
		ListNode before;
	
		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
	class LRUList{
		ListNode first = new ListNode(-1, -1);
		ListNode last = first;
		int size = 0;

		public void add(ListNode node){
			node.before = last;
			last.after = node;
			last = node;
			size++;
		}
		
		public int removeFirst(){
			ListNode firstNode = first.after;
			if(firstNode == null) return -1;
			first.after = firstNode.after;
			if(firstNode.after != null){
				firstNode.after.before = first;
			}else{
			    last = first;
			}
			firstNode.before = null;
			firstNode.after = null;
			size--;
			return firstNode.key;
		}
		
		public void setToEnd(ListNode node){
			if(size < 2) return;
			//set to end of the list
			if(node == null || node.after == null) return;
			node.before.after = node.after;
			node.after.before = node.before;
			node.after = null;
			last.after = node;
			node.before = last;
			last = node;
		}
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		ListNode node = data.get(key);
		if(node == null){
			return -1;
		}else{
			lruList.setToEnd(node);
			return node.val;
		}
	}

	public void set(int key, int value) {
		ListNode node = data.get(key);
		if(node != null){
			node.val = value;
			lruList.setToEnd(node);
		}else{
			node = new ListNode(key, value);
			if(lruList.size >= capacity){
				//delete
				Integer eldestKey = lruList.removeFirst();
				data.remove(eldestKey);
			}
			lruList.add(node);
			data.put(key, node);
		}
	}
}