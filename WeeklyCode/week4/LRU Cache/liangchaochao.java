public class LRUCache {
    
    private int capacity;
    private Map<Integer,Node> maps;
    private Node head;
    private Node end;
    private int size;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;
        maps=new HashMap<Integer,Node>();
        head=new Node(-1,-1);
        end=new Node(-1,-1);
        size=0;
    }
    
    public int get(int key) {
        Node node=maps.get(key);
        if(node==null) return -1;
        return changeToHead(node);
    }
    
    public void set(int key, int value) {
        Node node=maps.get(key);
        if(node==null){
            if(size==capacity){
                maps.remove(deleteLastNode());
            }
            node=new Node(key,value);
            maps.put(key,node);
            insertToHead(node);
        }else{
            node.value=value;
            changeToHead(node);
        }
    }
    
    private int changeToHead(Node node){
        if(end.pre==node){
            end.pre=node.pre;
            end.pre.next=end;
        }
        else{
            node.pre.next=node.next;
            node.next.pre=node.pre;
        }
        node.next=head.next;
        head.next=node;
        if(node.next!=null)node.next.pre=node;
        node.pre=head;
        return node.value;
    }
    
    private void insertToHead(Node node){
        node.next=head.next;
        head.next=node;
        if(node.next!=null)node.next.pre=node;
        node.pre=head;       
        if(size==0) {
            end.pre=node;
            node.next=end;
        }
        size++;
    }
    
    private int deleteLastNode(){
    	int key=end.pre.key;
    	end.pre=end.pre.pre;
        end.pre.next=end;
        size--;
        return key;
    }
    
    private class Node{
        int key;
        int value;
        Node next;
        Node pre;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=null;
            pre=null;
        }
    }
}
